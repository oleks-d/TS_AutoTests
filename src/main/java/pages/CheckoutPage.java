package pages;

import entities.ItemEntity;
import entities.UserEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by odiachuk on 07.07.17.
 */
public class CheckoutPage extends BasePage {

    private static CheckoutPage instance;
    public static CheckoutPage Instance = (instance != null) ? instance : new CheckoutPage();

    public CheckoutPage(){
        pageURL = "/checkout/";
    }

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
    By street2Field = By.name("street[1]");
    By cityField = By.name("city");
    By postcodeField = By.name("postcode");
    //select
    By regionSelect = By.name("region_id");
    //select
    By countrySelect = By.name("country_id");
    By phoneField = By.name("telephone");
    By continueButton = By.cssSelector("button.action.continue.primary");

    By freeShippingRadioButton = By.xpath(".//*[@id='s_method_freeshipping_freeshipping']");

    //order list

    By orderItems = By.cssSelector("div.block.items-in-cart ol.minicart-items li.product-item");
    By orderItemName = By.cssSelector("strong.product-item-name");
    By orderItemQty = By.cssSelector("div.details-qty span.value");
    By orderItemPrice = By.cssSelector("span.cart-price");
    By orderItemDetails= By.cssSelector("dl.item-options span");

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

    public CheckoutPage setStreet2(String street2){
        reporter.info("Set Street details: " + street2);
        setText(street2Field, street2);
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
        scrollToElement(driver().findElement(continueButton));
        waitForElement(continueButton);
        clickOnElement(continueButton);
        return CheckoutReviewPage.Instance;
    }

    public CheckoutReviewPage selectFreeShipping(){
        reporter.info("Selecting Free Shipping option");
        scrollToElement(driver().findElement(freeShippingRadioButton));
        waitForElement(freeShippingRadioButton);
        findElement(freeShippingRadioButton).click();
        return CheckoutReviewPage.Instance;
    }

    public CheckoutPage populateAllCheckoutFields(UserEntity user) {
        this.setEmail(user.getContacts().getEmail())
                .setFirstName(user.getFirstname())
                .setLastName(user.getLastname())
                .setCompany(user.getContacts().getCompany())
                .setStreet(user.getAddress().getStreet())
                .setStreet2(user.getAddress().getStreet_2())
                .setCity(user.getAddress().getCity())
                .selectRegion(user.getAddress().getRegion())
                .setPostcode(user.getAddress().getZip())
                .setPhone(user.getContacts().getPhone());
        return this;
    }

    public boolean itemDisplayedOnCheckoutPage(ItemEntity item) {
        ArrayList<ItemEntity> items = getAllCheckoutPageItems();
        reporter.info("Expected item: " + item.toString());
        return items.stream()
                .filter(cur -> item.getTitle().equals(cur.getTitle()))
                .filter(cur -> item.getQty() == cur.getQty())
                .filter(cur -> item.getPrice() == cur.getPrice())
                .filter(cur -> cur.getType().contains(item.getType()))
                .filter(cur -> cur.getSize().contains(item.getSize())).count() > 0;
    }

    private ArrayList<ItemEntity> getAllCheckoutPageItems() {
        ArrayList<ItemEntity> result = new ArrayList<>();
        reporter.info("Getting order items");
        findElementIgnoreException(orderItems); // wait for order
        List<WebElement> itemsList = findElementsIgnoreException(orderItems);
        for (WebElement orderItem : itemsList ) {
            ItemEntity currentItem = new ItemEntity();

            currentItem.setTitle(orderItem.findElement(orderItemName).getText());

            currentItem.setQty(Integer.valueOf(orderItem.findElement(orderItemQty).getText()));

            currentItem.setPrice(Tools.convertStringPriceToFloat(orderItem.findElement(orderItemPrice).getText()));
            currentItem.setSize("");
            currentItem.setType("");

            List<WebElement> details = orderItem.findElements(orderItemDetails);

            for(WebElement elem : details){
                String value = elem.getText();
                if (value.contains("(") && value.contains(")"))
                    currentItem.setSize(value);
                else
                    currentItem.setType(value);
            }

            reporter.info("Order item: " + currentItem.toString());
            result.add(currentItem);

        }

        if (itemsList.size() == 0) {
            reporter.info("No items were found on Checkout page");
            //Assert.fail("No items were found on Checkout page");
        }

        return result;
    }
}
