package pages;

import entities.UserEntity;
import org.apache.xpath.operations.Variable;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by Kos on 7/12/17.
 */
public class AccountPage extends LoginPage {

    private static AccountPage instance;
    public static AccountPage Instance = (instance != null) ? instance : new AccountPage();

    public AccountPage(){
        pageURL = "/customer/account/";
    }

    /**
     * Common elements
     **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

    //** Sidebar links */

    By mySocialAccounts = By.xpath("//*[@id=\'block-collapsible-nav\']/ul/li[1]/a");
    By myDashboard = By.xpath("//*[@id=\'block-collapsible-nav\']/ul/li[2]/a");
    By myAccountInfo = By.xpath("//*[@id=\'block-collapsible-nav\']/ul/li[3]/a");
    By myAddressBook = By.xpath("//*[@id=\'block-collapsible-nav\']/ul/li[4]/a");
    By myOrders = By.xpath("//*[@id=\'block-collapsible-nav\']/ul/li[5]/a");
    By myReviews = By.xpath("//*[@id=\'block-collapsible-nav\']/ul/li[6]/a");
    By myNewsletter = By.xpath("//*[@id=\'block-collapsible-nav\']/ul/li[7]/a");


    //My Social Accounts

    By linkedAccounts = By.xpath("//STRONG[text()='Linked accounts']");




    //Dashboard Elements

    By userNameLocator = By.xpath(" //DIV[@class='box box-information']");
    By editAccountButton = By.xpath("(//A[@class='action edit'])[1]");
    By changePasswordButton = By.xpath("//A[@href='https://www.tomorrowsleep.com/customer/account/edit/changepass/1/']");

    By subscriptionLocator = By.xpath("(//DIV[@class='box-content'])[2]");
    By editSubscriptionButton = By.xpath("(//A[@class='action edit'])[2]");

    By defaultBillingAddressLocator = By.xpath("(//ADDRESS)[1]");
    By deafultShippingAddressLocator = By.xpath("(//ADDRESS)[2]");
    By editBillingAddress = By.xpath("(//A[@class='action edit'])[4]");
    By editShippingAddress = By.xpath("(//A[@class='action edit'])[5]");


    //Account Info Elements

    By firstNameField = By.xpath("//INPUT[@id='firstname']");
    By lastNameField = By.xpath("//INPUT[@id='lastname']");
    By accountInfoChangeEmailButton = By.xpath("//SPAN[text()='Change Email']");
    By accountInfoChangePasswordButton = By.xpath("//SPAN[text()='Change Password']");
    By newEmailField = By.id("email");
    By currentPasswordField = By.id("current-password");
    By newPasswordField = By.id("password");
    By confirmNewPasswordField = By.id("password-confirmation");
    By saveAccountInfoButton = By.xpath("//SPAN[text()='Save']");

    //Address Book Elements
    By billingAddressBox = By.xpath("//DIV[@class='box box-address-billing']");
    By shippingAddressBox = By.xpath("//DIV[@class='box box-address-shipping']");
    By changeBillingAddressButton = By.xpath("//SPAN[text()='Change Billing Address']");
    By changeShippingAddressButton = By.xpath("//SPAN[text()='Change Shipping Address']");

    By companyField = By.id("company");
    By phoneNumberField = By.id("telephone");
    By faxNumberField = By.id("fax");
    By street1AddressField = By.id("street_1");
    By street2AddressField = By.id("street_2");
    By cityField = By.id("city");
    By stateField = By.id("region_id");
    By zipField = By.id("zip");
    By countryField = By.id("country");
    By saveAddressButton = By.xpath("(//SPAN[text()='Save Address'][text()='Save Address'])[1]");

    By updatedAddressSuccessMessage = By.xpath("//DIV[@class='message-success success message']");

    //My Orders Elements todo need to add order history locator if there are any
    By noOrdersMessage = By.xpath("//SPAN[text()='You have placed no orders.']");

    //My Reviews Elements todo blank page issue

    //Newsletter elements todo
    By subscriptionCheckbox = By.id("subscription");
    By subscriptionSaveButton = By.xpath("//SPAN[text()='Save']");
    By removeSubscriptionSuccessMessage = By.xpath("//DIV[@data-bind='html: message.text'][text()='We removed the subscription.']");
    By enableSubscriptionSuccessMessage = By.xpath("//DIV[@data-bind='html: message.text'][text()='We saved the subscription.']");




    /** Page Methods */

    //My Social Account Methods
    public void ClickOnMySocialAccounts(){
        reporter.info("Click on My Social Accounts");
        findElement(mySocialAccounts).click();
    }

    public String getSocialAccounts(){
        return findElement(linkedAccounts).getText();
    }




    //My Dashboard Methods
    public void ClickOnMyDashboard(){
        reporter.info("Click on My Dashboard");
        findElement(myDashboard).click();
    }

    public String getUserNameText() {
        return findElement(userNameLocator).getText();
    }

    public boolean verifyDashboardElements(){
        reporter.info("Check for elements on Dasboard");
        return isElementPresent(editAccountButton)
                && isElementPresent(changePasswordButton)
                && isElementPresent(subscriptionLocator)
                && isElementPresent(editSubscriptionButton)
                && isElementPresent(defaultBillingAddressLocator)
                && isElementPresent(deafultShippingAddressLocator)
                && isElementPresent(editBillingAddress)
                && isElementPresent(editShippingAddress);
    }

    //Account Info Methods
    public void ClickOnMyAccountInfo(){
        reporter.info("Click on My Account Info");
        findElement(myAccountInfo).click();
    }

    public boolean verifyAccountInfoElements(){
        reporter.info("Check for elements on Account Info");
        return isElementPresent(firstNameField)
                && isElementPresent(lastNameField)
                && isElementPresent(accountInfoChangeEmailButton)
                && isElementPresent(accountInfoChangePasswordButton);
    }

    public AccountPage clickOnChangeEmailButton(){
        reporter.info("Click on change Email Button");
        scrollToElement(driver().findElement(accountInfoChangeEmailButton));
        findElement(accountInfoChangeEmailButton).click();
        return this;
    }

    public AccountPage clickOnChangePasswordButton(){
        reporter.info("Click on change Password Button");
        scrollToElement(driver().findElement(accountInfoChangePasswordButton));
        findElement(accountInfoChangePasswordButton).click();
        return this;
    }

    public AccountPage updateEmail(String newEmail, String pass){
        reporter.info("Updating Email to " + newEmail);

        findElement(newEmailField).clear();
        findElement(newEmailField).sendKeys(newEmail);

        findElement(currentPasswordField).clear();
        findElement(currentPasswordField).sendKeys(pass);

        clickOnSaveAccountInfoButton();
        return this;
    }

    public AccountPage updatePassword(String pass, String newPass){
        reporter.info("Updating Password to " + newPass);

        findElement(currentPasswordField).clear();
        findElement(currentPasswordField).sendKeys(pass);

        findElement(newPasswordField).clear();
        findElement(newPasswordField).sendKeys(newPass);

        findElement(confirmNewPasswordField).clear();
        findElement(confirmNewPasswordField).sendKeys(newPass);

        clickOnSaveAccountInfoButton();
        return this;
    }

    public AccountPage updateFirstname(String firstname){
        reporter.info("Updating firstname to " + firstname);
        findElement(firstNameField).clear();
        findElement(firstNameField).sendKeys(firstname);
        return this;
    }

    public AccountPage updateLastname(String lastname){
        reporter.info("Updating Lastname to " + lastname);
        findElement(lastNameField).clear();
        findElement(lastNameField).sendKeys(lastname);
        return this;
    }

    public AccountPage clickOnSaveAccountInfoButton(){
        reporter.info("Clicking on Save button");
        waitForElement(saveAccountInfoButton);
        scrollToElement(driver().findElement(saveAccountInfoButton));
        findElement(saveAccountInfoButton).click();
        return this;
    }




    //Address Book Methods
    public void ClickOnMyAddressBook(){
        reporter.info("Click on My Address Book");
        scrollToElement(driver().findElement(myAddressBook));
        findElement(myAddressBook).click();
    }

    public boolean verifyAddressBookElements(){
        reporter.info("Check for elements on Address Book");
        return isElementPresent(billingAddressBox)
                && isElementPresent(shippingAddressBox)
                && isElementPresent(changeBillingAddressButton)
                && isElementPresent(changeShippingAddressButton);
    }

    public void ClickOnChangeShippingAddressButton(){
        reporter.info("Click on Change Shipping Address");
        scrollToElement(driver().findElement(changeShippingAddressButton));
        findElement(changeShippingAddressButton).click();
    }

    public void ClickOnChangeBillingAddressButton(){
        reporter.info("Click on Change Billing Address");
        scrollToElement(driver().findElement(changeBillingAddressButton));
        findElement(changeBillingAddressButton).click();
    }

    public void updateAddress(UserEntity user){
        reporter.info("Enter new address");

        reporter.info("The firstname is " + user.getFirstname());
        findElement(firstNameField).clear();
        findElement(firstNameField).sendKeys(user.getFirstname());

        reporter.info("The lastname is " + user.getLastname());
        findElement(lastNameField).clear();
        findElement(lastNameField).sendKeys(user.getLastname());

        reporter.info("The company is " + user.getContacts().getCompany());
        findElement(companyField).clear();
        findElement(companyField).sendKeys(user.getContacts().getCompany());

        reporter.info("Phone number is " + user.getContacts().getPhone());
        findElement(phoneNumberField).clear();
        findElement(phoneNumberField).sendKeys(user.getContacts().getPhone());

        reporter.info("Fax is " + user.getContacts().getFax());
        findElement(faxNumberField).clear();
        findElement(faxNumberField).sendKeys(user.getContacts().getFax());

        reporter.info("Street address 1 is " + user.getAddress().getStreet());
        findElement(street1AddressField).clear();
        findElement(street1AddressField).sendKeys(user.getAddress().getStreet());

        reporter.info("Street address 2 is " + user.getAddress().getStreet_2());
        findElement(street2AddressField).clear();
        findElement(street2AddressField).sendKeys(user.getAddress().getStreet_2());

        reporter.info("City is " + user.getAddress().getCity());
        findElement(cityField).clear();
        findElement(cityField).sendKeys(user.getAddress().getCity());

        reporter.info(user.getAddress().getRegion() + " is selected for State");
        selectFromDropdown(stateField, user.getAddress().getRegion());

        reporter.info("Zip is " + user.getAddress().getZip());
        findElement(zipField).clear();
        findElement(zipField).sendKeys(user.getAddress().getZip());

        reporter.info(user.getAddress().getCountry() +" is selected for Country");
        selectFromDropdown(countryField, user.getAddress().getCountry());

        clickOnSaveAddress();
    }

    public void clickOnSaveAddress(){
        reporter.info("Click on Save Address");
        waitForElement(saveAddressButton);
        scrollToElement(driver().findElement(saveAddressButton));
        findElement(saveAddressButton).click();
    }

    public boolean verifyAddressUpdateShipping(UserEntity user){
        reporter.info("Search for updated data in the Shipping Address Box");
        return findElement(shippingAddressBox).getText().contains(user.getFirstname())
                && findElement(shippingAddressBox).getText().contains(user.getLastname())
                && findElement(shippingAddressBox).getText().contains(user.getContacts().getCompany())
                && findElement(shippingAddressBox).getText().contains(user.getContacts().getPhone())
                //&& findElement(shippingAddressBox).getText().contains(user.getContacts().getFax())
                && findElement(shippingAddressBox).getText().contains(user.getAddress().getStreet())
                && findElement(shippingAddressBox).getText().contains(user.getAddress().getStreet_2())
                && findElement(shippingAddressBox).getText().contains(user.getAddress().getCity())
                && findElement(shippingAddressBox).getText().contains(user.getAddress().getRegion())
                && findElement(shippingAddressBox).getText().contains(user.getAddress().getCountry())
                && findElement(shippingAddressBox).getText().contains(user.getAddress().getZip());
    }

    public boolean verifyAddressUpdateBilling(UserEntity user){
        reporter.info("Search for updated data in the Shipping Address Box");
        return findElement(billingAddressBox).getText().contains(user.getFirstname())
                && findElement(billingAddressBox).getText().contains(user.getLastname())
                && findElement(billingAddressBox).getText().contains(user.getContacts().getCompany())
                && findElement(billingAddressBox).getText().contains(user.getContacts().getPhone())
                //&& findElement(billingAddressBox).getText().contains(user.getContacts().getFax())
                && findElement(billingAddressBox).getText().contains(user.getAddress().getStreet())
                && findElement(billingAddressBox).getText().contains(user.getAddress().getStreet_2())
                && findElement(billingAddressBox).getText().contains(user.getAddress().getCity())
                && findElement(billingAddressBox).getText().contains(user.getAddress().getRegion())
                && findElement(billingAddressBox).getText().contains(user.getAddress().getCountry())
                && findElement(billingAddressBox).getText().contains(user.getAddress().getZip());
    }

    public boolean checkForSuccessMessage(){
        return isElementPresent(updatedAddressSuccessMessage);
    }


    //My Orders Methods

    public void ClickOnMyOrders(){
        reporter.info("Click on My Orders");
        scrollToElement(driver().findElement(myOrders));
        findElement(myOrders).click();
    }

    public boolean verifyNoOrdersMessage(){
        reporter.info("Check for elements on My Orders page");
        return isElementPresent(noOrdersMessage);
    }

    //My Reviews Methods todo

    public void ClickOnMyReviews(){
        reporter.info("Click on My Reviews");
        scrollToElement(driver().findElement(myReviews));
        findElement(myReviews).click();
    }

    //My Newsletter Methods todo

    public void ClickOnMyNewsletter(){
        reporter.info("Click on My Newsletter");
        scrollToElement(driver().findElement(myNewsletter));
        findElement(myNewsletter).click();
    }

    public boolean getSubscriptionStatus(){
        return findElement(subscriptionCheckbox).isSelected();
    }

    public void changeSubscriptionStatus(){
        if (getSubscriptionStatus()){
            reporter.info("Newsletter subscription is active");
            findElement(subscriptionCheckbox).click();
            findElement(subscriptionSaveButton).click();
            reporter.info("Removing subscription");
            Assert.assertTrue(findElement(removeSubscriptionSuccessMessage).isDisplayed(), "Failed to remove subscription");
        }
        else {
            reporter.info("Newsletter subscription is NOT active");
            findElement(subscriptionCheckbox).click();
            findElement(subscriptionSaveButton).click();
            reporter.info("Enabling subscription");
            Assert.assertTrue(findElement(enableSubscriptionSuccessMessage).isDisplayed(), "Failed to enable subscription");
        }
    }


}

