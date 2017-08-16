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

    @Test
    @TestName(name="Change Email")
    public void ChangeAccountEmail() throws Exception {

        SetupProcedures sp = new SetupProcedures();
        String nameOfNewUser = sp.setupNewAccount();

        String newEmail = "tomorrow.autotest+" + Tools.getRandomUserEmail();

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;

        login.enterUsername(nameOfNewUser);
        login.enterPassword(nameOfNewUser);
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(nameOfNewUser), "Failed to login" );


        //Update Email
        account.ClickOnMyAccountInfo();
        account.clickOnChangeEmailButton();

        account.updateEmail(newEmail, nameOfNewUser);
        Assert.assertTrue(account.getUserNameText().contains(newEmail), "Failed to locate updated Email" );
    }

}
