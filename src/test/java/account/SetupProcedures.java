package account;

import entities.UserEntity;
import org.testng.Assert;
import pages.AccountPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Tools;

/**
 * Created by odiachuk on 24.07.17.
 */
public class SetupProcedures {

    // setup new account and return username

    public String setupNewAccount(){

        String userName = "tomorrow.autotest+" + Tools.getRandomUserEmail();
        String userPassword = userName;

        CreateAccountPage accountPage = CreateAccountPage.Instance;
        accountPage.open();
        accountPage.createAccount(userName, userPassword);
        HomePage.Instance.header.clickSignOutMenuItem();

        return userName;
    }


    public String setupNewAccount(UserEntity user){

        String userName = "tomorrow.autotest+" + Tools.getRandomUserEmail();
        String userPassword = userName;
        String userEmail = userName;

        user.setUsername(userName);
        user.getContacts().setEmail(userEmail);
        user.setPassword(userPassword);

        CreateAccountPage accountPage = CreateAccountPage.Instance;
        accountPage.open();
        accountPage.createAccount(userName, userPassword);

        AccountPage account = AccountPage.Instance;
        account.ClickOnMyAddressBook();
        account.updateAddress(user);

        HomePage.Instance.header.clickSignOutMenuItem();

        return userName;
    }

}
