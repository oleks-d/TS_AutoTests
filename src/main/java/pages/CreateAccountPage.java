package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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




    //* Page Methods *//
    public CreateAccountPage clickOnCreateAnAccount(){
        reporter.info("Click on Create An Account Button");
        scrollToElement(driver().findElement(createAnAccountButton));
        findElement(createAnAccountButton).click();
        return this;
    }

    public boolean checkFieldsValidation(){
        reporter.info("Check for 'This Field is required' message");
        if (isElementPresent(emailInputFieldError)
                && isElementPresent(firstNameInputFieldError)
                && isElementPresent(lastNameInputFieldError)
                && isElementPresent(passwordInputFieldError)
                && isElementPresent(confirmPasswordInputFieldError)){
            return true;
        }else{
            return false;
        }
    }

    public AccountPage createAccount(String userName, String userPassword){

        reporter.info("Enter user Email " + userName);
        findElement(emailInputField).clear();
        findElement(emailInputField).sendKeys(userName);

        reporter.info("Enter Firstname " + userName);
        findElement(firstNameInputField).clear();
        findElement(firstNameInputField).sendKeys(userName);

        reporter.info("Enter Lastname " + userName);
        findElement(lastNameInputField).clear();
        findElement(lastNameInputField).sendKeys(userName);

        reporter.info("Enter Password " + userPassword);
        findElement(passwordInputField).clear();
        findElement(passwordInputField).sendKeys(userPassword);

        reporter.info("Enter ConfirmPassword " + userPassword);
        findElement(confirmPasswordInputField).clear();
        findElement(confirmPasswordInputField).sendKeys(userPassword);

        clickOnCreateAnAccount();

        return AccountPage.Instance;
    }

}
