package pages;

import entities.UserEntity;
import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class CheckoutPage extends BasePage {


    private final static String pageTitle = "";
    private static CheckoutPage instance;
    public static CheckoutPage Instance = (instance != null) ? instance : new CheckoutPage();

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

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
    By continueButton = By.cssSelector("button.action.continue.primary");

    //cart list

    By productItems = By.cssSelector("div.block.items-in-cart ol.minicart-items li.product-item");

    // strong class="product-item-name" - product name

    //("div.product.options div.content") - content
    //        ("span.cart-price") - price
    //       ("div.details-qty span.value") - qty


    /** Page Methods */

    public CheckoutPage setEmail(String email){
        reporter.info("Set Email name: " + email);
        findElement(emailField).sendKeys(email);
        return this;
    }

    public CheckoutPage setLastName(String lastname){
        reporter.info("Set Last name: " + lastname);
        findElement(lastnameField).sendKeys(lastname);
        return this;
    }

    public CheckoutPage setFirstName(String firstname){
        reporter.info("Set First name: " + firstname);
        findElement(firstnameField).sendKeys(firstname);
        return this;
    }


    public CheckoutPage setCompany(String company){
        reporter.info("Set Company name: " + company);
        findElement(companyField).sendKeys(company);
        return this;
    }

    public CheckoutPage setStreet(String street){
        reporter.info("Set Street name: " + street);
        findElement(streetField).sendKeys(street);
        return this;
    }

    public CheckoutPage setCity(String city){
        reporter.info("Set City name: " + city);
        findElement(cityField).sendKeys(city);
        return this;
    }


    public CheckoutPage selectCountry(String country){
        reporter.info("Select Country name: " + country);
        selectFromDropdown(countrySelect, country);
        return this;
    }

    public CheckoutPage selectRegion(String region){
        reporter.info("Select Region name: " + region);
        selectFromDropdown(regionSelect, region);
        return this;
    }

    public CheckoutPage setPostcode(String postcode){
        reporter.info("Set Postcode name: " + postcode);
        findElement(postcodeField).sendKeys(postcode);
        return this;
    }

    public CheckoutPage setPhone(String phone){
        reporter.info("Set Phone name: " + phone);
        findElement(phoneField).sendKeys(phone);
        return this;
    }

    public CheckoutReviewPage clickNextButton(){
        reporter.info("Click on Next button");
        clickOnElement(continueButton);
        return CheckoutReviewPage.Instance;
    }


    public CheckoutPage populateAllCheckoutFields(UserEntity user) {
        this.setFirstName(user.getFirstname())
                .setLastName(user.getLastname())
                .setCity(user.getAddress().getCity())
                .setCompany(user.getContacts().getCompany())
                .setEmail(user.getContacts().getEmail())
                .setPhone(user.getContacts().getPhone())
                .setPostcode(user.getAddress().getZip())
                .setStreet(user.getAddress().getStreet())
                .selectRegion(user.getAddress().getRegion());
        return this;
    }
}
