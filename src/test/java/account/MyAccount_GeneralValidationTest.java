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

/**
 * Created by Kos on 7/17/17.
 */
public class MyAccount_GeneralValidationTest extends BaseTest {

    @Test
    @TestName(name="My Account General Validation")
    public void userSignIn_GeneralValidationTest() throws Exception {

        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("AccTest_User.json"));

        //User Sign in

        HomePage home = HomePage.Instance;
        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(user.getUsername());
        login.enterPassword(user.getPassword());
        login.submitForm();

        AccountPage account = AccountPage.Instance;


        //Browse through My Account pages
        account.ClickOnMySocialAccounts();
        Assert.assertTrue(account.getSocialAccounts().contains("Linked accounts"), "Failed to open My Social Accounts");

        account.ClickOnMyDashboard();
        Assert.assertTrue(account.verifyDashboardElements() , "Failed to open Dashboard");

        account.ClickOnMyAccountInfo();
        Assert.assertTrue(account.verifyAccountInfoElements(), "Failed to open Account Info");

        account.ClickOnMyAddressBook();
        Assert.assertTrue(account.verifyAddressBookElements(), "Failed to open Address Book" );

        account.ClickOnMyOrders();
        Assert.assertTrue(account.verifyNoOrdersMessage(), "Failed to open My Orders");

        //account.ClickOnMyReviews();

        account.ClickOnMyNewsletter();
        account.changeSubscriptionStatus();
    }

}
