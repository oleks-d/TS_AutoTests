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
import utils.Tools;

/**
 * Created by Kos on 7/17/17.
 */
public class MyAccount_ChangeEmailTest extends BaseTest {

    @DataProvider(name = "provider")
        public Object[][] provider() throws Exception {
            return new Object[][]{
                    {EntitiesFactory.getUser(FileIO.getDataFile("AccTest_User.json"))}
            };
    }

    String currenttime = Tools.getCurDateTime();
    String newEmail = currenttime + "@mail.com";

    @Test (dataProvider = "provider")
    @TestName(name="Change Email")
    public void ChangeAccountAddress(UserEntity user) throws Exception {

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;

        login.enterUsername(user.getUsername());
        login.enterPassword(user.getPassword());
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(user.getUsername()), "Failed to login" );

        account.ClickOnMyAccountInfo();
        account.clickOnChangeEmailButton();

        account.updateEmail(newEmail, user); //todo save new Email to json
        Assert.assertTrue(account.getUserNameText().contains(newEmail), "Failed to locate updated Email" );



    }

}
