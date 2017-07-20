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

    public LoginPage enterUsername(UserEntity user) {
        reporter.info("Entering username: " + user.getUsername());
        findElement(usernameLocator).clear();
        findElement(usernameLocator).sendKeys(user.getUsername());
        return this;
    }

    public void enterPassword(UserEntity user) {
        reporter.info("Entering password: " + user.getPassword());
        findElement(passwordLocator).clear();
        findElement(passwordLocator).sendKeys(user.getPassword());
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
