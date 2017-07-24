package smoke;

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
public class UpdateAccountTest extends BaseTest {

    String username = "qazxsw@mailinator.com";
    String password = "!@qwASzx";
    String firstname = "reserving";
    String lastname = "data";

    @DataProvider(name = "provider")
        public Object[][] provider() throws Exception {
            return new Object[][]{
                    //{new UserEntity("","","", new ContactsEntity("","",""), new AddressEntity("","","","",""))},
                    {
                        EntitiesFactory.getUser(FileIO.getDataFile("AccTest_User.json"))}
            };
    }

    @Test (dataProvider = "provider")
    public void UpdateAccount(UserEntity user) throws Exception {

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(user);
        login.enterPassword(user);
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(username), "Failed to login" );

        account.ClickOnMyAddressBook();
        account.ClickOnChangeShippingAddressButton();

        account.updateAddress(user);

        Assert.assertTrue(account.checkForSuccessMessage(), "Failed to locate Success message");

        Assert.assertTrue(account.verifyAddressUpdateShipping(user), "Failed to update Address");


    }

}
