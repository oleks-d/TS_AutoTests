package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class CheckoutPage extends BasePage {


    private final static String pageTitle = "";
    private static CheckoutPage instance;
    public static CheckoutPage Instance = (instance != null) ? instance : new CheckoutPage();

    CheckoutPage() {
        instance = Instance;
        waitForPageToLoad();
    }

    /**
     * UI Mappings
     */

    By emailField = By.id("customer-email");
    By lastnameField = By.name("lastname");
    By firstnameField = By.name("firstname");
    By companyField = By.name("company");
    By streetField = By.name("street[0]");
    By cityField = By.name("city");
    By postcodeField = By.name("postcode");
    //select
    By regionSelect = By.name("region_id");
    //select
    By countrySelect = By.name("country_id");
    By phoneField = By.name("telephone");
    By continueButton = By.cssSelector("button action continue primary");

    //cart list

    By productItems = By.cssSelector("div.block.items-in-cart ol.minicart-items li.product-item");

    // strong class="product-item-name" - product name

    //("div.product.options div.content") - content
    //        ("span.cart-price") - price
    //       ("div.details-qty span.value") - qty


    /** Page Methods */


}
