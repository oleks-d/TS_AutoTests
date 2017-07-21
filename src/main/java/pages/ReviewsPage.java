package pages;

import org.openqa.selenium.By;

/**
 * Created by Arsen Shliapskiy 07/20/17
 */

public class ReviewsPage extends BasePage {

    private static ReviewsPage instance;
    public static ReviewsPage Instance = (instance != null) ? instance : new ReviewsPage();

    public ReviewsPage() {
        pageURL = "/reviews";
    }

    /**
     * Common elements
     **/

    public PageHeader header = PageHeader.Instance;

    /**
     * UI Mappings
     */

    By topMenuItem_Reviews = By.xpath(".//*[@id='ui-id-6']/span");
    By clickOnWriteReview = By.xpath(".//*[@id='maincontent']/div[2]/div/div[5]/div/div/a");
    By enterLocation = By.xpath(".//*[@id='pr-location-input']");
    By selectDropDownList = By.xpath(".//*[@id='pr-mattressfeel']/option[3]");
    By chooseRating = By.xpath(".//*[@id='pr-rating']/div/div[5]");
    By inputHeadline = By.xpath(".//*[@id='pr-headline-input']");
    By inputComment = By.xpath(".//*[@id='pr-comments']");
    By inputName = By.xpath(".//*[@id='pr-name-input']");
    By inputEmail = By.xpath(".//*[@id='pr-email_collection-input']");
    By submitReview = By.xpath(".//*[@id='pr-write']/div/div/div[5]/div[3]/div/div[1]");

    /**
     * Confirmation Variables
     */
    By confirmText =  By.xpath("//*[text()='New York']");

    /**
     * Page Methods
     */

    public ReviewsPage rev() {
        reporter.info("Click on REVIEW menu item");
        findElement(topMenuItem_Reviews).click();
        return this;
    }

    public void clickOnWriteReview() {
        reporter.info("Click in Write A Review Button");
        findElement(clickOnWriteReview).click();
    }

    public void enterLocation() {
        reporter.info("Entering location");
        findElement(enterLocation).clear();
        findElement(enterLocation).sendKeys("New York");
    }

    public void selectDropDownList() {
        reporter.info("Select Soft From DropDownList");
        findElement(selectDropDownList).click();
    }

    public void chooseRating() {
        reporter.info("Choose rating Mark");
        findElement(chooseRating).click();
    }

    public void inputHeadline() {
        reporter.info("Entering text");
        findElement(inputHeadline).clear();
        findElement(inputHeadline).sendKeys("Best Night Sleep Ever");
    }

    public void inputComment() {
        reporter.info("Entering comments");
        findElement(inputComment).clear();
        findElement(inputComment).sendKeys("I've never slept in a more comfortable bed");
    }

    public void inputName() {
        reporter.info("Entering Name");
        findElement(inputName).clear();
        findElement(inputName).sendKeys("John");
    }

    public void inputEmail() {
        reporter.info("Entering email");
        findElement(inputEmail).clear();
        findElement(inputEmail).sendKeys("John@test.com");
    }

    public void submitReview() {
        reporter.info("Click on submit review button");
        findElement(submitReview).click();
    }
}

    //Review Page Verification

    /*
    public String getYourLocationText(){
    String getYourLocationText = findElement(confirmText).getText();
        reporter.info("Review page contains " + getYourLocationText);
        return getYourLocationText;
    }
     */
