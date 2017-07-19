package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class LoginPage extends BasePage {

    private static LoginPage instance;
    public static LoginPage Instance = (instance != null) ? instance : new LoginPage();

    public LoginPage(){
        pageURL = "/customer/account/login/";
    }

    /** UI Mappings */

    By usernameLocator = By.id("email");
    By passwordLocator = By.id("pass");
    By loginButtonLocator = By.id("send2");
    By createAccountLinkLocator = By.xpath("//SPAN[text()='CREATE AN ACCOUNT']");

    /** Page Methods */

    public LoginPage enterUsername(String username) {
        reporter.info("Entering username: " + username);
        findElement(usernameLocator).clear();
        findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public void enterPassword(String password) {
        reporter.info("Entering password: " + password);
        findElement(passwordLocator).clear();
        findElement(passwordLocator).sendKeys(password);
    }

    public AccountPage submitForm() {
        reporter.info("Submitting Login form");
        clickOnElement(loginButtonLocator);
        return AccountPage.Instance;
    }

    public CreateAccountPage clickCreateAnAccount(){
        reporter.info("Click on Create Account button");
        findElement(createAccountLinkLocator).click();
        return CreateAccountPage.Instance;
    }


}
