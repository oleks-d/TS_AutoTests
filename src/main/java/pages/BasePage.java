package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.FileIO;
import utils.ReporterManager;

/**
 * Created by odiachuk on 07.07.17.
 */
public class BasePage {

    public ThreadLocal<String> URL = new ThreadLocal<String>();
    protected String pageTitle;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    static final int DEFAULT_TIMEOUT = Integer.parseInt(FileIO.getConfigProperty("DefaultTimeoutInSeconds"));

    public BasePage() {
       // waitForPageToLoad();
    }

    static ReporterManager reporter = ReporterManager.Instance;

    public static WebDriver driver(){
        return driver.get();
    }


    public BasePage(String pageTitle) {
        //this();
        this.pageTitle = pageTitle;
    }

    public boolean isPageLoaded() {
        reporter.info("Page title is: " + driver().getTitle());
        return (driver().getTitle().contains(pageTitle));
    }

    public void reloadPage() {
        driver().navigate().refresh();
    }

    public void open() {
        if ( URL.get() == null)
            URL.set(FileIO.getConfigProperty("Environment"));
        else
            URL.set(FileIO.getConfigProperty("Environment") + URL.get() );

        reporter.info("Opening the page: " + "\"" + URL.get() + "\"");
        driver().get(URL.get());
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
        reporter.info("The requested URL is: " + URL.get());
        return URL.get();
    }

    protected void sendText(String cssSelector, String text) {
        findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public boolean isTextPresent(String text) {
        return driver().getPageSource().contains(text);
    }

    public boolean isElementPresent(By by) {
        try {
            WebElement element = findElement(by);
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
            findElement(By.cssSelector(_cssSelector));
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public boolean isElementPresentAndDisplay(By by) {
        try {
            return findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getWebElement(By by) {
        return findElement(by);
    }
//
//        public static boolean verifyPageNotLoading(WebDriver driver, int timeToWait)
//        {
//            By loadingIndicator = By.xpath("//div[text()='Loading...']");
//
//            int i = 0;
//            boolean result = false;
//
//            while (i < 30)
//            {
//                WaitTool.setImplicitWait(driver, 1);
//                FileIO.logger("Checking page load status...", 2);
//                FileIO.logger("Current wait time is: " + i, 2);
//                result = ExpectedConditions.invisibilityOfElementLocated(loadingIndicator).apply(driver);
//
//                if (result == true)
//                {
//                    FileIO.logger("Loading element is no longer visible. Continuing execution...", 2);
//                    WaitTool.nullifyImplicitWait(driver);
//                    break;
//                }
//
//                i = i + 1;
//
//            }
//
//            return result;
//
//        }

//        /**
//         * Checks for the presence of the loading image commonly associated with
//         * tables loading within salesforce. In service cloud iframes also utilize
//         * this loading image (as opposed to the large Loading...overlay) with
//         * iframes. This function is a duplicate Core.verifyNotLoading that is
//         * associated with salescloud
//         *
//         * @param driver
//         * @param timeToWait
//         * @return
//         */
//        public static boolean verifyContextNotLoading(WebDriver driver, int timeToWait)
//        {
//            By loadingIndicator = By.cssSelector("img[title='Please Wait...']");
//
//            int i = 0;
//            boolean result = false;
//
//            while (i < 30)
//            {
//                WaitTool.setImplicitWait(driver, 1);
//                FileIO.logger("Waiting 1 sec then returning result. Current wait time is:" + i, 2);
//                result = ExpectedConditions.invisibilityOfElementLocated(loadingIndicator).apply(driver);
//
//                if (result == true)
//                {
//                    FileIO.logger("Context Loading element is no longer visible. Continuing execution.", 2);
//                    WaitTool.nullifyImplicitWait(driver);
//                    break;
//                }
//
//                i = i + 1;
//
//            }
//
//            return result;
//
//        }

    public static void selectFromDropdown(By element, String value){
        Select dropdown = new Select(findElement(element));
        dropdown.selectByVisibleText(value);
    }


    public static void clickOnElementIgnoreException(By element, int... timeout) {
        waitForPageToLoad();
        try {
            clickOnElement(element, timeout[0]);
        } catch (RuntimeException e) {
            reporter.info("Got exception. Exception is expected and ignored.");
        }
    }

    public static WebElement findElementIgnoreException(By element, int... timeout) {
        waitForPageToLoad();
        try {
            return findElement(element, timeout[0]);
        } catch (RuntimeException e) {
            reporter.info("Got exception. Exception is expected and ignored.");
        }
        return null;
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
            reporter.info("Got exception. Exception is expected and ignored.");
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
            throw new RuntimeException("Failure clicking on element");
        }
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
        ((JavascriptExecutor) driver()).executeScript("arguments[0].focus(); window.scroll(0, window.scrollY+=200)",element);

    }

    public static void waitForPageToLoad(){

        //reporter.info("Waiting for page to load");

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
            //reporter.info("Returned a ready state of complete");
        } catch (Exception error)
        {
            reporter.fail("JavaScript readyState query timeout - The page has not finished loading", error);
        }

        //FileIO.takeScreenshot( driver, String.valueOf(System.currentTimeMillis()) );

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
            } catch (NoAlertPresentException e)  // чекаємо секунду
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
}
