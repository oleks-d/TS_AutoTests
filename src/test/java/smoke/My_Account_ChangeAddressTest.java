package smoke;

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
public class My_Account_ChangeAddressTest extends BaseTest {

    @DataProvider(name = "provider")
        public Object[][] provider() throws Exception {
            return new Object[][]{
                    {EntitiesFactory.getUser(FileIO.getDataFile("AccTest_User.json"))}
            };
    }

    @Test (dataProvider = "provider")
    @TestName(name="Change Address")
    public void ChangeAccountAddress(UserEntity user) throws Exception {

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;

        login.enterUsername(user)
            .enterPassword(user);

        login.submitForm();

        AccountPage account = AccountPage.Instance;
        Assert.assertTrue(account.getUserNameText().contains(user.getUsername()), "Failed to login" );

        account.ClickOnMyAddressBook();



        //Update Shipping Address
        account.ClickOnChangeShippingAddressButton();

        account.updateAddress(user);

        Assert.assertTrue(account.verifyUpdatedAddressMessage(), "Failed to locate Success Message");

        Assert.assertTrue(account.verifyAddressUpdateShipping(user), "Failed to update Shipping Address");



        //Update Billing Address
        account.ClickOnChangeBillingAddressButton();

        account.updateAddress(user);

        Assert.assertTrue(account.verifyUpdatedAddressMessage(), "Failed to locate Success Message");

        Assert.assertTrue(account.verifyAddressUpdateBilling(user), "Failed to update Billing Address");

    }

}
