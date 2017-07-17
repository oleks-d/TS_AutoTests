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
    By accountInformationTitle = By.xpath("//*[@id=\'maincontent\']/div[2]/div[1]/div[3]/div[1]/strong");
    By addressBookTitle = By.xpath("//*[@id=\'maincontent\']/div[2]/div[1]/div[4]/div[1]/strong");

    //Account Info Elements

    //Address Book Elements

    //My Orders Elements

    //My Reviews Elements

    //Newsletter elements

    /** Page Methods */

    public String getUserNameText() {
        String userNameText = findElement(userNameLocator).getText();
        return  userNameText;
    }

    public void ClickOnMySocialAccounts(){
        reporter.info("Click on My Social Accounts");
        findElement(mySocialAccounts).click();
    }

    public void ClickOnMyDashboard(){
        reporter.info("Click on My Dashboard");
        findElement(myDashboard).click();
    }

    public void ClickOnMyAccountInfo(){
        reporter.info("Click on My Account Info");
        findElement(myAccountInfo).click();
    }

    public void ClickOnMyAddressBook(){
        reporter.info("Click on My Address Book");
        findElement(myAddressBook).click();
    }

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
    public String getSocialAccounts(){
        String getSocialAccounts = findElement(linkedAccounts).getText();
        return getSocialAccounts;
    }

    //My Dashboard Methods
    public String getDashboardAccount(){
        String getDashboardAccount = findElement(accountInformationTitle).getText();
        reporter.info("Account information Title is "+ accountInformationTitle);
        return getDashboardAccount;
    }

    public String getDashboardAddress(){
        String getDashboardAddress = findElement(addressBookTitle).getText();
        return getDashboardAddress;
    }
}
