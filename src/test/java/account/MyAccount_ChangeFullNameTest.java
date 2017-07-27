package account;

import annotations.TestName;
import entities.AddressEntity;
import entities.BaseEntity;
import entities.ContactsEntity;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;
import utils.Tools;

/**
 * Created by Kos on 7/17/17.
 */
public class MyAccount_ChangeFullNameTest extends BaseTest {

    @Test
    @TestName(name = "Update full name")
    public void updateAccount() throws Exception {


        SetupProcedures sp = new SetupProcedures();

        String nameOfNewUser = sp.setupNewAccount();

        String newFirstname = Tools.getCurDateTime() + "first";
        String newLastname = Tools.getCurDateTime() + "last";


        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(nameOfNewUser);
        login.enterPassword(nameOfNewUser);
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(nameOfNewUser), "Failed to login" );

        account.ClickOnMyAccountInfo();  //Update first and last name
        account.updateFirstname(newFirstname);
        account.updateLastname(newLastname);
        account.clickOnSaveAccountInfoButton();

        Assert.assertTrue(account.getUserNameText().contains(newFirstname), "Failed to locate updated Firstname");
        Assert.assertTrue(account.getUserNameText().contains(newLastname), "Failed to locate updated Lastname");
    }

}