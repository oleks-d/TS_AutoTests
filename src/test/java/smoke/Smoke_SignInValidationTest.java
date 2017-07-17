package smoke;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class Smoke_SignInValidationTest extends BaseTest {

    String username = "qazxsw@mailinator.com";
    String password = "!@qwASzx";

    @Test
    @TestName(name="SignIn validation")
    public void userSignIn_GeneralValidationTest(){

        HomePage home = HomePage.Instance;
        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(username);
        login.enterPassword(password);
        login.submitForm();

        AccountPage account = AccountPage.Instance;

        Assert.assertTrue(account.getUserNameText().contains(username), "Expected account page was not opened" );
    }
}
