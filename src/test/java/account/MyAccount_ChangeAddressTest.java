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
public class MyAccount_ChangeAddressTest extends BaseTest {

    @Test
    @TestName(name = "Update Existing Account")
    public void updateExistingAccount() throws Exception {

        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("UserTemplate.json"));
        UserEntity updatedUser = EntitiesFactory.getUser(FileIO.getDataFile("UserTemplate2.json"));

        SetupProcedures sp = new SetupProcedures();

        String nameOfNewUser = sp.setupNewAccount(user);
        user.setUsername(nameOfNewUser);
        user.getContacts().setEmail(nameOfNewUser);

        HomePage home = HomePage.Instance;

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(nameOfNewUser);
        login.enterPassword(nameOfNewUser);
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(nameOfNewUser), "Failed to login" );

        account.ClickOnMyAddressBook();
        account.ClickOnChangeShippingAddressButton();

        account.updateAddress(updatedUser); // fill blank fields on Address book

        Assert.assertTrue(account.checkForSuccessMessage(), "Failed to locate Success message");
        Assert.assertTrue(account.verifyAddressUpdateShipping(updatedUser), "Failed to update Address");
    }

    @Test
    @TestName(name = "Update New Account")
    public void updateNewAccount() throws Exception {

        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("UserTemplate.json"));

        SetupProcedures sp = new SetupProcedures();

        String nameOfNewUser = sp.setupNewAccount();
        user.setUsername(nameOfNewUser);
        user.getContacts().setEmail(nameOfNewUser);

        HomePage home = HomePage.Instance;

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(nameOfNewUser);
        login.enterPassword(nameOfNewUser);
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(nameOfNewUser), "Failed to login" );

        account.ClickOnMyAddressBook();

        account.updateAddress(user); // fill blank fields on Address book

        Assert.assertTrue(account.checkForSuccessMessage(), "Failed to locate Success message");
        Assert.assertTrue(account.verifyAddressUpdateShipping(user), "Failed to update Address");
    }
}
