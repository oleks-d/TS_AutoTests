package smoke;

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

    @DataProvider(name = "provider")
    public Object[][] provider() throws Exception {
        return new Object[][]{
                {EntitiesFactory.getUser(FileIO.getDataFile("AccTest_User.json"))}
        };
    }


    @Test  (dataProvider = "provider")
    @TestName(name="SignIn validation")
    public void userSignIn_GeneralValidationTest(UserEntity user) throws Exception {

        HomePage home = HomePage.Instance;
        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(user);
        login.enterPassword(user);
        login.submitForm();

        AccountPage account = AccountPage.Instance;

        Assert.assertTrue(account.getUserNameText().contains(user.getUsername()), "Expected account page was not opened" );
    }
}
