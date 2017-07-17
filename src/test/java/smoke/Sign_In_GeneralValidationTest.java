package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class Sign_In_GeneralValidationTest extends BaseTest {

    String username = "qazxsw@mailinator.com";
    String password = "!@qwASzx";



    @Test
    public void userSignIn_GeneralValidationTest(){

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(username);
        login.enterPassword(password);
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(username), "Failed to login" );

    }

}
