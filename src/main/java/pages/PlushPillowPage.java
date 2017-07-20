package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class PlushPillowPage extends BaseProductPage{

        private static PlushPillowPage instance;
        public static PlushPillowPage Instance = (instance != null) ? instance : new PlushPillowPage();

    public PlushPillowPage(){
        pageURL = "/hypoallergenic-pillow";
    }

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

//    By addToCartButton = By.id("product-addtocart-button");

    /** Page Methods */

    public PlushPillowPage clickAddToCart() {
        super.clickAddToCart();
        return this;
    }
}
