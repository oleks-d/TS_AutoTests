package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.DataProvider;
import utils.FileIO;
import utils.ReporterManager;
import utils.Tools;

/**
 * Created by odiachuk on 07.07.17.
 */
public class BasePage {

    static ReporterManager reporter = ReporterManager.Instance;

    public final static String BASE_URL = (FileIO.getConfigProperty("Environment"));

    public String pageURL = "";
    public String pageTitle = "";

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static final int DEFAULT_TIMEOUT = getTimeout();
    public static final int SHORT_TIMEOUT = getShortTimeout();
    public static final int STATIC_TIMEOUT =  getStaticTimeout();

    private static int getTimeout() {
        String timeout = FileIO.getConfigProperty("DefaultTimeoutInSeconds");
        if (timeout == null ) {
            reporter.fatalFail("DefaultTimeoutInSeconds parameter was not found");
            timeout = "15";
        };

        return Integer.parseInt(timeout);
    }

    private static int getShortTimeout() {
        String timeout = FileIO.getConfigProperty("ShortTimeoutInSeconds");
        if (timeout == null ) {
            timeout = "3";
        };

        return Integer.parseInt(timeout);
    }

    private static int getStaticTimeout() {
        String timeout = FileIO.getConfigProperty("StaticTimeoutMilliseconds");
            if (timeout == null ) {
                    timeout = "1000";
            };
        return Integer.parseInt(timeout);
    }

    public BasePage() {
       // waitForPageToLoad();
    }

    public static WebDriver driver(){
        return driver.get();
    }

    public boolean isPageLoaded() {
        boolean result = false;
        reporter.info("Page title is: " + driver().getTitle());
        reporter.info("Page URL is: " + driver().getCurrentUrl());
        if (driver().getTitle().contains(pageTitle))
            result = true;
        else {
            reporter.info("Expected title: " + pageTitle);
            result = false;
        }

        if (driver().getCurrentUrl().contains(pageURL))
            result = true;
        else {
            reporter.info("Expected URL: " + pageURL);
            result = false;
        }

        return result;
    }

    public void reloadPage() {
        driver().navigate().refresh();
    }

    public void open() {

        reporter.info("Opening the page: " + "\"" + BASE_URL + pageURL + "\"");
        if (FileIO.getConfigProperty("EnvType").equals("Staging")){
            driver().get("https://bettersleep:stg-tsleep-@45@staging.tomorrowsleep.com");
        }else {
            driver().get(BASE_URL + pageURL);
        }
        driver().manage().window().maximize();

    }

    public void close() {
        reporter.info("Closing the browser");
        driver().close();
    }

    public String getTitle() {
        reporter.info("The page title is: " + "\"" + pageTitle + "\"");
        return pageTitle;
    }

    public String getURL() {
        reporter.info("The requested URL is: " + BASE_URL + pageURL);
        return BASE_URL + pageURL;
    }

    protected void sendText(String cssSelector, String text) {
        findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public void setText(By element, String value){
        if (value != null) {
            findElement(element).clear();
            findElement(element).sendKeys(value);
        }
    }

    public boolean isTextPresent(String text) {
        return driver().getPageSource().contains(text);
    }

    public boolean isElementPresent(By by) {
        try {
            WebElement element = findElementIgnoreException(by);
            return element.isDisplayed();
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean isElementPresent(String _cssSelector) {
        try {
            findElementIgnoreException(By.cssSelector(_cssSelector));
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean isElementPresentAndDisplay(By by) {
        try {
            return findElementIgnoreException(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayedRightNow(By by) {
        try {
            return findElementIgnoreException(by, SHORT_TIMEOUT).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getWebElement(By by) {
        return findElement(by);
    }


    public static void selectFromDropdown(By element, String value){
        Select dropdown = new Select(findElement(element));
        dropdown.selectByVisibleText(value);
    }


    public static void clickOnElementIgnoreException(By element, int... timeout) {
        waitForPageToLoad();
        int timeoutForFindElement = timeout.length < 1 ? DEFAULT_TIMEOUT : timeout[0];
        try {
            (new WebDriverWait(driver(), timeoutForFindElement))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            driver().findElement(element).click();
        } catch (Exception e) {
            // nothing
        }
        waitForPageToLoad();
    }

    public static WebElement findElementIgnoreException(By element, int... timeout) {
        waitForPageToLoad();
        int timeoutForFindElement = timeout.length < 1 ? DEFAULT_TIMEOUT : timeout[0];
        waitForPageToLoad();
        try {
            //synchronize();
            (new WebDriverWait(driver(), timeoutForFindElement))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            return driver().findElement(element);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<WebElement> findElementsIgnoreException(By element, int... timeout) {
        int timeoutForFindElement = timeout.length < 1 ? DEFAULT_TIMEOUT : timeout[0];
        waitForPageToLoad();
        try {
            //synchronize();
            (new WebDriverWait(driver(), timeoutForFindElement))
                    .until(ExpectedConditions.presenceOfElementLocated(element));
            return driver().findElements(element);
        } catch (Exception e) {
            //reporter.info("Got exception. Exception is expected and ignored.");
            return new ArrayList<WebElement>();
        }
    }

    public static void clickOnElement(By element, int... timeout) {
        int timeoutForFindElement = timeout.length < 1 ? DEFAULT_TIMEOUT : timeout[0];
        waitForPageToLoad();
        try {
            (new WebDriverWait(driver(), timeoutForFindElement))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            driver().findElement(element).click();
        } catch (Exception e) {
            reporter.fail(Tools.getStackTrace(e));
            throw new RuntimeException("Failure clicking on element" );
        }
        waitForPageToLoad();
    }

    public static WebElement findElement(By element, int... timeout) {
        int timeoutForFindElement = timeout.length < 1 ? DEFAULT_TIMEOUT : timeout[0];
        waitForPageToLoad();
        try {
            //synchronize();
            (new WebDriverWait(driver(), timeoutForFindElement))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            return driver().findElement(element);
        } catch (Exception e) {
            reporter.fail(Tools.getStackTrace(e));
            throw new RuntimeException("Failure finding element");
        }
    }

    public static List<WebElement> findElements(By element, int... timeout) {
        int timeoutForFindElement = timeout.length < 1 ? DEFAULT_TIMEOUT : timeout[0];
        waitForPageToLoad();
        try {
            //synchronize();
            (new WebDriverWait(driver(), timeoutForFindElement))
                    .until(ExpectedConditions.presenceOfElementLocated(element));
            return driver().findElements(element);
        } catch (Exception e) {
            reporter.fail(Tools.getStackTrace(e));
            throw new RuntimeException("Failure finding elements");
        }
    }

    public static String getAttributeIDIgnoreExecption(By element, int... timeout) {
        waitForPageToLoad();
        try {
            return getAttributeID(element, timeout[0]);
        } catch (RuntimeException e) {
            reporter.info("Got exception. Exception is expected and ignored.");
        }
        return null;
    }

    public static String getAttributeID(By element, int... timeout) {
        int timeoutForFindElement = timeout.length < 1 ? DEFAULT_TIMEOUT : timeout[0];
        waitForPageToLoad();
        try {
            //synchronize();
            (new WebDriverWait(driver(), timeoutForFindElement))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
            String id = findElement(element).getAttribute("id");
            return id;
        } catch (Exception e) {
            throw new RuntimeException("Failure getting attribute id of an element");
        }
    }

    public static void setDriverContextToPage(WebDriver driver) {
        reporter.info("Setting the context mode to Page");
        driver.switchTo().defaultContent();
    }

    public static void scrollToElement(WebElement element) {
        waitForPageToLoad();
        ((JavascriptExecutor) driver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollToShopElement(WebElement element){
        waitForPageToLoad();
        ((JavascriptExecutor) driver()).executeScript("arguments[0].focus(); window.scroll(0, window.scrollY+=200)",element);
    }

    public static void waitForPageToLoad(){
        sleepFor(STATIC_TIMEOUT); // todo fixme
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver)
            {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .equals("complete");
            }

        };

        Wait<WebDriver> wait = new WebDriverWait(driver(), DEFAULT_TIMEOUT);

        try
        {
            wait.until(expectation);
        } catch (Exception error)
        {
            reporter.fail("JavaScript readyState query timeout - The page has not finished loading");
        }

//        String source = driver().getPageSource();
//
//        expectation = new ExpectedCondition<Boolean>() {
//
//            public Boolean apply(WebDriver driver)
//            {
//                return ((JavascriptExecutor) driver).executeScript("return jQuery.active")
//                        .equals("0");
//            }
//
//        };
//
//        wait = new WebDriverWait(driver(), DEFAULT_TIMEOUT);
//
//        try
//        {
//            wait.until(expectation);
//        } catch (Exception error)
//        {
//            reporter.fail("The page has not finished loading");
//        }

    }

    static void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver(), DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void sleepFor(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
        }
    }

    static void waitForAlert(WebDriver driver, int timeout) {
        int i = 0;
        while (i++ < timeout) {
            try {
                Alert alert = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e)  // wait for second
            {
                sleepFor(1);
                continue;
            }
        }
    }

    /*
    static void waitForElement(WebDriver driver, By by, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    } */


    // Does not work because of geckodriver bug - https://stackoverflow.com/questions/40360223/webdriverexception-moveto-did-not-match-a-known-command
    public void hoverItem(By element){
        reporter.info("Put mouse pointer over element: " + element.toString());
        Actions action = new Actions(driver());
        action.moveToElement(findElement(element)).build().perform();
    }

    public void switchToFrame(By xpath) {
        reporter.info("Switch to frame: " + xpath.toString());
        driver().switchTo().frame(findElement(xpath));
    }

    public void switchToDefaultContent(){
        reporter.info("Switch to default content");
        driver().switchTo().defaultContent();
    }

    public HomePage closeWelcomeMessage(){
            reporter.info("Closing welcome popup");
            waitForElement(By.xpath("//SPAN[@class='close-button']"));
            findElement(By.xpath("//SPAN[@class='close-button']")).click();
        return HomePage.Instance;
    }

}
