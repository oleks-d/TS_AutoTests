package pages;

import org.openqa.selenium.By;

/**
 * Created by Kos on 7/12/17.
 */
public class AccountPage extends LoginPage {

    private static AccountPage instance;
    public static AccountPage Instance = (instance != null) ? instance : new AccountPage();

    public AccountPage(){
        pageURL = "/account";
    } //todo: check url

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
    By linkedAccounts = By.xpath("//*[@id=\'maincontent\']/div[2]/div[1]/div[3]/div[1]/strong");




    //Dashboard Elements
    By userNameLocator = By.xpath("//span[text()='Contact Information']/../..//div/p");
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
    By accountInfoEmailButton = By.xpath("//SPAN[text()='Change Email']");
    By accountInfoPasswordButton = By.xpath("//SPAN[text()='Change Password']");

    //Address Book Elements
    By billingAddressBox = By.xpath("//DIV[@class='box box-address-billing']");
    public By shippingAddressBox = By.xpath("//DIV[@class='box box-address-shipping']");
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

    public By updatedAddressSuccessMessage = By.xpath("//DIV[@class='message-success success message']");
    //My Orders Elements

    //My Reviews Elements

    //Newsletter elements

    /** Page Methods */
    public void ClickOnMyOrders(){
        reporter.info("Click on My Orders");
        findElement(myOrders).click();
    }

    public void ClickOnMyReviews(){
        reporter.info("Click on My Reviews");
        findElement(myReviews).click();
    }

    public void ClickOnMyNewsletter(){
        reporter.info("Click on My Newsletter");
        findElement(myNewsletter).click();
    }




    //My Social Account Methods
    public void ClickOnMySocialAccounts(){
        reporter.info("Click on My Social Accounts");
        findElement(mySocialAccounts).click();
    }

    public String getSocialAccounts(){
        String getSocialAccounts = findElement(linkedAccounts).getText();
        return getSocialAccounts;
    }




    //My Dashboard Methods
    public void ClickOnMyDashboard(){
        reporter.info("Click on My Dashboard");
        findElement(myDashboard).click();
    }

    public String getUserNameText() {
        String userNameText = findElement(userNameLocator).getText();
        return  userNameText;
    }

    public boolean verifyDashboardElements(){
        reporter.info("Check for elements on Dasboard");
        if (isElementPresent(editAccountButton)
                && isElementPresent(changePasswordButton)
                && isElementPresent(subscriptionLocator)
                && isElementPresent(editSubscriptionButton)
                && isElementPresent(defaultBillingAddressLocator)
                && isElementPresent(deafultShippingAddressLocator)
                && isElementPresent(editBillingAddress)
                && isElementPresent(editShippingAddress)){
            return true;
        }else{
            return false;
        }
    }

    //Account Info Methods
    public void ClickOnMyAccountInfo(){
        reporter.info("Click on My Account Info");
        findElement(myAccountInfo).click();
    }

    public boolean verifyAccountInfoElements(){
        reporter.info("Check for elements on Account Info");
        if (isElementPresent(firstNameField)
                && isElementPresent(lastNameField)
                && isElementPresent(accountInfoEmailButton)
                && isElementPresent(accountInfoPasswordButton)){
            return true;
        }else{
            return false;
        }
    }



    //Address Book Methods
    public void ClickOnMyAddressBook(){
        reporter.info("Click on My Address Book");
        findElement(myAddressBook).click();
    }

    public boolean verifyAddressBookElements(){
        reporter.info("Check for elements on Address Book");
        if (isElementPresent(billingAddressBox)
                && isElementPresent(shippingAddressBox)
                && isElementPresent(changeBillingAddressButton)
                && isElementPresent(changeShippingAddressButton)){
            return true;
        }else{
            return false;
        }
    }

    public AccountPage ClickOnChangeShippingAddressButton(){
        reporter.info("Click on change shipping address");
        findElement(changeShippingAddressButton).click();
        return this;
    }

    public AccountPage updateAddress(String firstname, String lastname, String company, String phone, String fax,
                                     String street_1, String street_2, String city, String region, String country, String zip){
        reporter.info("Enter new address");

        reporter.info("The firstname is " + firstname);
        findElement(firstNameField).clear();
        findElement(firstNameField).sendKeys(firstname);

        reporter.info("The lastname is " + lastname);
        findElement(lastNameField).clear();
        findElement(lastNameField).sendKeys(lastname);

        reporter.info("The company is " + company);
        findElement(companyField).clear();
        findElement(companyField).sendKeys(company);

        reporter.info("Phone number is " + phone);
        findElement(phoneNumberField).clear();
        findElement(phoneNumberField).sendKeys(phone);

        reporter.info("Fax is " + fax);
        findElement(faxNumberField).clear();
        findElement(faxNumberField).sendKeys(fax);

        reporter.info("Street address 1 is " + street_1);
        findElement(street1AddressField).clear();
        findElement(street1AddressField).sendKeys(street_1);

        reporter.info("Street address 2 is " + street_2);
        findElement(street2AddressField).clear();
        findElement(street2AddressField).sendKeys(street_2);

        reporter.info("City is " + city);
        findElement(cityField).clear();
        findElement(cityField).sendKeys(city);

        reporter.info(region + " is selected for State");
        selectFromDropdown(stateField, region);

        reporter.info("Zip is " + zip);
        findElement(zipField).clear();
        findElement(zipField).sendKeys(zip);

        reporter.info(country +" is selected for Country");
        selectFromDropdown(countryField, country);

        reporter.info("Click on Save Address");
        findElement(saveAddressButton).click();

        return this;
    }

    public boolean verifyAddressUpdate(String company, String phone, String fax,
                        String street_1, String street_2, String city, String region, String country, String zip){
        reporter.info("Search for updated data in the Address Box");
        if( findElement(shippingAddressBox).getText().contains(company)
                && findElement(shippingAddressBox).getText().contains(phone)
                //&& findElement(shippingAddressBox).getText().contains(fax)
                && findElement(shippingAddressBox).getText().contains(street_1)
                && findElement(shippingAddressBox).getText().contains(street_2)
                && findElement(shippingAddressBox).getText().contains(city)
                && findElement(shippingAddressBox).getText().contains(region)
                && findElement(shippingAddressBox).getText().contains(country)
                && findElement(shippingAddressBox).getText().contains(zip)){
            return true;
        }else{
            return false;
        }
    }
}
