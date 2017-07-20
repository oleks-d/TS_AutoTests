package pages;

import org.openqa.selenium.By;
import utils.Tools;

/**
 * Created by Kos on 7/17/17.
 */
public class CreateAccountPage extends BasePage {

    private final static String pageTitle = " ";
    private static CreateAccountPage instance;
    public static CreateAccountPage Instance = (instance != null) ? instance : new CreateAccountPage();

    public CreateAccountPage(){
        pageURL = "/customer/account/create/";
    }

    public String userdata = Tools.getCurDateTime();
    String userpassword = "!QAZxsw2";

    //* UI Mappings *//

    By emailInputField = By.id("email_address");
    By firstNameInputField = By.id("firstname");
    By lastNameInputField = By.id("lastname");
    By passwordInputField = By.id("password");
    By confirmPasswordInputField = By.id("password-confirmation");
    By createAnAccountButton = By.xpath("(//SPAN[text()='Create an Account'][text()='Create an Account'])[1]");

        //Error Messages //
    By emailInputFieldError = By.id("email_address-error");
    By firstNameInputFieldError = By.id("firstname-error");
    By lastNameInputFieldError = By.id("lastname-error");
    By passwordInputFieldError = By.id("password-error");
    By confirmPasswordInputFieldError = By.id("password-confirmation-error");

    String userInfo = Tools.getCurDateTime();


    //* Page Methods *//
    public CreateAccountPage clickOnCreateAnAccountBlank(){
        reporter.info("Click on Create An Account Button");
        findElement(createAnAccountButton).click();
        return this;
    }

    public boolean checkFieldValidation(){
        reporter.info("Check for 'This Field is required' message");
        if (isElementPresent(emailInputFieldError) && isElementPresent(firstNameInputField) && isElementPresent(lastNameInputField) && isElementPresent(passwordInputFieldError) && isElementPresent(confirmPasswordInputFieldError)){
            return true;
        }else{
            return false;
        }
    }

    public CreateAccountPage inputNewUserInfo(){
        reporter.info("Enter user Email "+userdata+"@mail.com");
        findElement(emailInputField).clear();
        findElement(emailInputField).sendKeys(userdata+"@mail.com");
        reporter.info("Enter Firstname "+userdata);
        findElement(firstNameInputField).clear();
        findElement(firstNameInputField).sendKeys(userdata);
        reporter.info("Enter Lastname "+userdata);
        findElement(lastNameInputField).clear();
        findElement(lastNameInputField).sendKeys(userdata);
        reporter.info("Enter Password "+userpassword);
        findElement(passwordInputField).clear();
        findElement(passwordInputField).sendKeys(userpassword);
        reporter.info("Enter ConfirmPassword "+userpassword);
        findElement(confirmPasswordInputField).clear();
        findElement(confirmPasswordInputField).sendKeys(userpassword);
        findElement(createAnAccountButton).click();
        return this;
    }

}
