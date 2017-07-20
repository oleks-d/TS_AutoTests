package pages;

import org.openqa.selenium.By;

/**
 * Created by noname
 */

public class ReviewsPage extends BasePage {

    private static ReviewsPage instance;
    public static ReviewsPage Instance = (instance != null) ? instance : new ReviewsPage();

    public ReviewsPage() {
        pageURL = "/";
    }

    /**
     * Common elements
     **/

    public PageHeader header = PageHeader.Instance;

    /**
     * UI Mappings
     */

    By topMenuItem_Review = By.xpath("//ul[@class='header links']//a[contains(text(),'Reviews')]");

    /**
     * Page Methods
     */

    public ReviewsPage clickReviews() {
        reporter.info("Click on REVIEW menu item");
        findElement(topMenuItem_Review).click();
        return this;
    }
}