package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class PlushPillowPage extends BasePage{


        private final static String pageTitle = "";
        private static PlushPillowPage instance;
        public static PlushPillowPage Instance = (instance != null) ? instance : new PlushPillowPage();

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

    By addToCartButton = By.id("product-addtocart-button");

    /** Page Methods */

    public PlushPillowPage clickAddToCart() {
        reporter.info("Click Add to cart button");
        clickOnElement(addToCartButton);
        return this;
    }
}
