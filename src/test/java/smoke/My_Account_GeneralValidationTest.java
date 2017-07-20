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

/**
 * Created by Kos on 7/17/17.
 */
public class My_Account_GeneralValidationTest extends BaseTest {

    @DataProvider(name = "provider")
    public Object[][] provider() throws Exception {
        return new Object[][]{
                {EntitiesFactory.getUser(FileIO.getDataFile("AccTest_User.json"))}
        };
    }


    @Test (dataProvider = "provider")
    @TestName(name="My Account General Validation")
    public void userSignIn_GeneralValidationTest(UserEntity user) throws Exception {

        //User Sign in

        HomePage home = HomePage.Instance;
        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(user);
        login.enterPassword(user);
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
    }

}
