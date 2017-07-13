package pages;

import org.openqa.selenium.By;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kos on 7/12/17.
 */
public class AccountPage extends LoginPage {


    private final static String pageTitle = "";
    private static AccountPage instance;
    public static AccountPage Instance = (instance != null) ? instance : new AccountPage();

    /**
     * Common elements
     **/

    public PageHeader header = PageHeader.Instance;

    AccountPage() {
        instance = Instance;
        waitForPageToLoad();
    }

    By userLocator = By.xpath("//span[text()='Contact Information']/../..//div/p");



}
