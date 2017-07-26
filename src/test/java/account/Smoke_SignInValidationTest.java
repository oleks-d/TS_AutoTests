package account;

import annotations.TestName;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

public class Smoke_SignInValidationTest extends BaseTest {

    @Test
    @TestName(name="SignIn validation")
    public void userSignIn_GeneralValidationTest() throws Exception {

        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("AccTest_User.json"));

        HomePage home = HomePage.Instance;
        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(user.getUsername());
        login.enterPassword(user.getPassword());
        login.submitForm();

        AccountPage account = AccountPage.Instance;

        Assert.assertTrue(account.getUserNameText().contains(user.getUsername()), "Expected account page was not opened" );
    }
}
