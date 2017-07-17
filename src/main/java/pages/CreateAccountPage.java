package pages;

import org.openqa.selenium.By;
import sun.jvm.hotspot.memory.HeapBlock;

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

}
