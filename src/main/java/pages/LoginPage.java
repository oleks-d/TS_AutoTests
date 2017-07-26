package pages;

import entities.UserEntity;
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

    public LoginPage enterUsername(String user) {
        reporter.info("Entering username: " + user);
        findElement(usernameLocator).clear();
        findElement(usernameLocator).sendKeys(user);
        return this;
    }

    public void enterPassword(String pass) {
        reporter.info("Entering password: " + pass);
        findElement(passwordLocator).clear();
        findElement(passwordLocator).sendKeys(pass);
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
