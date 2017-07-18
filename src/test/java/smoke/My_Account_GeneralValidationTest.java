package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

/**
 * Created by Kos on 7/17/17.
 */
public class My_Account_GeneralValidationTest extends BaseTest {

    String username = "qazxsw@mailinator.com";
    String password = "!@qwASzx";


    @Test
    public void userSignIn_GeneralValidationTest() {

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);/
        AccountPage account = AccountPage.Instance;

        userSignIn_GeneralValidationTest();

        account.ClickOnMySocialAccounts();
        Assert.assertTrue(account.getSocialAccounts().contains("Linked accounts"), "Failed to open My Social Accounts");

        account.ClickOnMyDashboard();
        Assert.assertTrue(account.getDashboardAccount().contains("Account Information") && account.getDashboardAddress().contains("Address Book"), "Failed to open Dashboard");

        account.ClickOnMyAccountInfo();


        account.ClickOnMyAddressBook();


        account.ClickOnMyOrders();


        //account.ClickOnMyReviews();


        account.ClickOnMyNewsletter();
    }

}
