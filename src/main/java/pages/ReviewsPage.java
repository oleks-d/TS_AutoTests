package pages;

import org.openqa.selenium.By;

/**
 * Created by noname
 */

public class ReviewsPage extends BasePage {

    private static ReviewsPage instance;
    public static ReviewsPage Instance = (instance != null) ? instance : new ReviewsPage();

    public ReviewsPage(){
        pageURL = "/";
    }
    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

    By topMenuItem_Review = By.xpath("//ul[@role='menu']//a[@role='menuitem']//span[text()='Reviews']")

    /** Page Methods */


    public ReviewsPage clicklReviewsMenuItem (){
        reporter.info("Click on REVIEW menu item");
        clickOnElement(topMenuItem_Review);
        return ReviewsPage.Instance;
    }