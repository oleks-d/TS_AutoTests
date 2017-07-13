package pages;

import org.openqa.selenium.By;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kos on 7/12/17.
 */
public class MyAccount extends LoginPage {


    private final static String pageTitle = "";
    private static MyAccount instance;
    public static MyAccount Instance = (instance != null) ? instance : new MyAccount();

    /**
     * Common elements
     **/

    public PageHeader header = PageHeader.Instance;

    MyAccount() {
        instance = Instance;
        waitForPageToLoad();
    }

    By user = By.xpath("//span[text()='Contact Information']/../..//div/p").getText();
}
