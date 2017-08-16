package account;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.Tools;

/**
 * Created by Kos on 7/17/17.
 */
public class CreateAccountTest extends BaseTest {

    @Test
    public void RegisterNewUser(){

        String userName = "tomorrow.autotest+" + Tools.getRandomUserEmail();
        String userPassword = "!QAZxsw2";

        HomePage home = HomePage.Instance;

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.clickCreateAnAccount();

        CreateAccountPage createaccount = CreateAccountPage.Instance;
        createaccount.clickOnCreateAnAccount();

        Assert.assertTrue(createaccount.checkFieldsValidation(), "Empty field validation failed");

        createaccount.createAccount(userName, userPassword);

        Assert.assertTrue(AccountPage.Instance.getUserNameText().contains(userName), "Failed to create new user account");

    }

}
