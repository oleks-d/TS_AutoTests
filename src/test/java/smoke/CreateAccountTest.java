package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

/**
 * Created by Kos on 7/17/17.
 */
public class CreateAccountTest extends BaseTest {


    @Test
    public void RegisterNewUser(){

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.clickCreateAnAccount();

        CreateAccountPage createaccount = CreateAccountPage.Instance;
        createaccount.clickOnCreateAnAccountBlank();

        Assert.assertTrue(createaccount.checkFieldValidation(), "Empty field validation failed");

        createaccount.inputNewUserInfo();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(createaccount.userdata), "Failed to create new user account");

    }

}
