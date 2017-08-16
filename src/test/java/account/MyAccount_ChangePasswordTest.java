package account;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.Tools;

/**
 * Created by Kos on 7/17/17.
 */
public class MyAccount_ChangePasswordTest extends BaseTest {

    @Test
    @TestName(name="Change Password")
    public void ChangeAccountEmail() throws Exception {

        SetupProcedures sp = new SetupProcedures();
        String nameOfNewUser = sp.setupNewAccount();
        String newPass = "tomorrow.autotest+" + Tools.getRandomUserEmail();

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();
        home.header.clickSignInMenuItem();

        LoginPage login = LoginPage.Instance;

        login.enterUsername(nameOfNewUser);
        login.enterPassword(nameOfNewUser);
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(nameOfNewUser), "Failed to login" );


        //Update password
        account.ClickOnMyAccountInfo();
        account.clickOnChangePasswordButton();
        account.updatePassword(nameOfNewUser, newPass);

        account.header.clickSignOutMenuItem();


        //Login with updated password
        login.open();
        login.enterUsername(nameOfNewUser);
        login.enterPassword(newPass);
        login.submitForm();
        Assert.assertTrue(account.getUserNameText().contains(nameOfNewUser), "Failed to login after password update" );

    }

}
