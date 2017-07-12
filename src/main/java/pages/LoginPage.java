package pages;

import org.openqa.selenium.By;
import utils.FileIO;

/**
 * Created by odiachuk on 07.07.17.
 */
public class LoginPage extends BasePage {

    private final static String pageTitle = " ";
    private static LoginPage instance;
    public static LoginPage Instance = (instance != null) ? instance : new LoginPage();

    LoginPage(){
        instance = Instance;
        waitForPageToLoad();
    }

    /** UI Mappings */

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.id("");
    By loginErrorLocator = By.id("");


    /** Page Methods */

    public HomePage doLogin(String password)
    {
        reporter.info("Logging in using the pass: " + password);

        this.open();
        this.enterPassword(password);
        return this.submitForm();
    }

    public void enterUsername(String username)
    {
        reporter.info("Entering username: " + username);

        findElement(usernameLocator).clear();
        findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        reporter.info("Entering password: " + password);

        findElement(passwordLocator).clear();
        findElement(passwordLocator).sendKeys(password);
    }

    public HomePage submitForm()
    {
        reporter.info("Submitting Login form");

        clickOnElement(loginButtonLocator);

        try
        {
            if (findElementsIgnoreException(loginErrorLocator, 2).size() > 0)
            {
                throw new Exception("Username/Password combination was NOT valid... ");
            }

        } catch (Exception e)
        {
            reporter.fail(e.getMessage(), e);
        }

        return HomePage.Instance;
    }


}
