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

    By userLocator = By.xpath("//span[text()='Contact Information']/../..//div/p");

    /** Page Methods */

    public String getUserNameText() {
        String userNameText = findElement(userLocator).getText();
        return  userNameText;
    }

}
