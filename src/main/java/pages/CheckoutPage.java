package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class CheckoutPage extends BasePage{


        private final static String pageTitle = "";
        private static CheckoutPage instance;
        public static CheckoutPage Instance = (instance != null) ? instance : new CheckoutPage();

        CheckoutPage(){
            instance = Instance;
            waitForPageToLoad();
        }

        /** UI Mappings */
/*
        By emailField = By.id("customer-email");
    By lastnameField = By.name("lastname");
    name="firstname"
    name="company"
    name="street[0]"
    name="city"
    select name="region_id"
    name="postcode"
    select name="country_id"
            input name="telephone"
                    button class="button action continue primary"

           productItems = By.cssSelector ("div.block.items-in-cart ol.minicart-items li.product-item");

productName strong class="product-item-name"

    cartContent = ("div.product.options div.content")
            ("span.cart-price") - price

            ("div.details-qty span.value") - qty

*/


        /** Page Methods */



}
