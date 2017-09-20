package pages;

import org.openqa.selenium.By;

/**
 * Created by obohachuk on 19.07.17.
 */
public class FaqPage extends BasePage{

    private static FaqPage instance;
    public static FaqPage Instance = (instance != null) ? instance : new FaqPage();

    public FaqPage(){
        pageURL = "/faq";
    }

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

    //Search
    By faqSearchField = By.xpath(".//*[@id='search']");
    By faqSearchButton = By.xpath(".//*[@id='search-validate-detail']/div[2]/button");

    //FAQ Menus
    By faqOurMattress = By.xpath(".//*[@class='subtitle']/../following-sibling:: ul/li[1]");
    By faqSleepSystem = By.xpath(".//*[@class='subtitle']/../following-sibling:: ul/li[2]");
    By faqSleeptracker = By.xpath(".//*[@class='subtitle']/../following-sibling:: ul/li[3]");
    By faqPurchasing = By.xpath(".//*[@class='subtitle']/../following-sibling:: ul/li[4]");
    By faqShipping = By.xpath(".//*[@class='subtitle']/../following-sibling:: ul/li[5]");
    By faqReturnsAndWarranty = By.xpath(".//*[@class='subtitle']/../following-sibling:: ul/li[6]");

    //Chat
    By faqChatSupport = By.xpath("//iframe[@data-test-id='ChatWidgetButton-iframe']']");

    //Locators
    By faqMattressTitle = By.xpath(".//*[text()='Our Mattress']");
    By faqSleepSystemTitle = By.xpath(".//*[text()='Sleep System']");
    By faqSleeptrackerTitle = By.xpath(".//*[text()='Sleeptracker ']");
    By faqPurchasingTitle = By.xpath(".//*[text()='Purchasing']");
    By faqShippingTitle = By.xpath(".//*[text()='Shipping & Delivery']");
    By faqReturnsAndWarrantyTitle = By.xpath(".//*[text()='Returns & Warranty']");
    By faqSearchResults = By.xpath(".//*[@class='title_desktop']/h2");

    //By faqChatSupportLocator = By.xpath("//*/label[text()='Leave us a Message']");


    public String faqPageUrl = "https://www.tomorrowsleep.com/faq";


    /** Page Methods */

    //Search

    public FaqPage clickOnFaqSearchField() {

        reporter.info("Click on Search Field");
        scrollToElement(driver().findElement(faqSearchField));
        findElement(faqSearchField).click();
        return this;
    }

    public FaqPage sendSearchRequest(String searchrequest) {
        reporter.info("Sending search request " + "'" + searchrequest + "'");
        findElement(faqSearchField).clear();
        findElement(faqSearchField).sendKeys(searchrequest);
        return this;
    }

    public FaqPage clickOnFaqSearchButton() {
        scrollToElement(driver().findElement(faqSearchButton));
        reporter.info("Click on Search Button");
        findElement(faqSearchButton).click();
        return this;
    }


    //FAQ Items

    public FaqPage clickOnfaqOurMattress() {
        scrollToElement(driver().findElement(faqOurMattress));
        reporter.info("Click on Our Mattress FAQ Item");
        findElement(faqOurMattress).click();
        return this;
    }

    public FaqPage clickOnfaqSleepSystem() {
        scrollToElement(driver().findElement(faqSleepSystem));
        reporter.info("Click on Sleep System Item");
        findElement(faqSleepSystem).click();
        return this;
    }

    public FaqPage clickOnfaqSleeptracker() {
        scrollToElement(driver().findElement(faqSleeptracker));
        reporter.info("Click on Sleeptracker Item");
        findElement(faqSleeptracker).click();
        return this;
    }

    public FaqPage clickOnfaqPurchasing() {
        scrollToElement(driver().findElement(faqPurchasing));
        reporter.info("Click on Purchasing Item");
        findElement(faqPurchasing).click();
        return this;
    }

    public FaqPage clickOnfaqShipping() {
        scrollToElement(driver().findElement(faqShipping));
        reporter.info("Click on Shipping Item");
        findElement(faqShipping).click();
        return this;
    }

    public FaqPage clickOnfaqReturnsAndWarranty() {
        scrollToElement(driver().findElement(faqReturnsAndWarranty));
        reporter.info("Click on Returns & Warranty Item");
        findElement(faqReturnsAndWarranty).click();
        return this;
    }


    //FAQ Chat Support

    public FaqPage clickOnfaqChatSupport() {
        reporter.info("Click on Chat Support window");
        switchToFrame(By.xpath("//iframe[@data-test-id='ChatWidgetButton-iframe']"));
        clickOnElement(By.xpath("//div"));
        switchToDefaultContent();
        return this;
    }




    //Search request verification

    public String getSearchRequestText() {
        scrollToElement(driver().findElement(faqSearchResults));
        String getSearchRequestText = findElement(faqSearchResults).getText();

        /*
        if(getSearchRequestText.contains(getSearchRequestText)){
            return getSearchRequestText;
        } else {
            reporter.fail("Requeste text field doesn't match " + "[" + getSearchRequestText + "]");
        }
        */
        reporter.info("Search request is: " + "[" + getSearchRequestText + "]");
        return getSearchRequestText;
    }


    //FAQ Items Verification

    public String getFaqMattressText() {
        scrollToElement(driver().findElement(faqMattressTitle));
        String getFaqMattressText = findElement(faqMattressTitle).getText();
        reporter.info("FAQ Title is " + "'" + getFaqMattressText + "'");
        return getFaqMattressText;
    }
    public String getFaqSleepSystemText() {
        scrollToElement(driver().findElement(faqSleepSystemTitle));
        String getFaqSleepSystepText = findElement(faqSleepSystemTitle).getText();
        reporter.info("FAQ Title is " + "'" + getFaqSleepSystepText + "'");
        return getFaqSleepSystepText;
    }

    public String getFaqSleeptrackerText() {
        scrollToElement(driver().findElement(faqSleeptrackerTitle));
        String getFaqSleeptrackerText = findElement(faqSleeptrackerTitle).getText();
        reporter.info("FAQ Title is " + "'" + getFaqSleeptrackerText + "'");
        return getFaqSleeptrackerText;
    }

    public String getFaqPurchasingText() {
        scrollToElement(driver().findElement(faqPurchasingTitle));
        String getFaqPurchasingText = findElement(faqPurchasingTitle).getText();
        reporter.info("FAQ Title is " + "'" + getFaqPurchasingText + "'");
        return getFaqPurchasingText;
    }

    public String getFaqShippingText() {
        scrollToElement(driver().findElement(faqShippingTitle));
        String getFaqShippingText = findElement(faqShippingTitle).getText();
        reporter.info("FAQ Title is " + "'" + getFaqShippingText + "'");
        return getFaqShippingText;
    }

    public String getFaqReturnsAndWarrantyText() {
        scrollToElement(driver().findElement(faqReturnsAndWarrantyTitle));
        String getFaqReturnsAndWarrantyText = findElement(faqReturnsAndWarrantyTitle).getText();
        reporter.info("FAQ Title is " + "'" + getFaqReturnsAndWarrantyText + "'");
        return getFaqReturnsAndWarrantyText;
    }

    // Chat Verification

//    public String getFaqChatSupportInputWindow() {
//        //scrollToElement(driver().findElement(faqChatSupportLocator));
//        String getFaqChatSupportInputWindow = findElement(faqChatSupportLocator).getText();
//        reporter.info("Chat window is captured: " + getFaqChatSupportInputWindow);
//        return getFaqChatSupportInputWindow;
//    }


}
