package account;

import org.testng.Assert;
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

        String userName = Tools.getRandomUserEmail();
        String userPassword = userName;

        HomePage.Instance.open();
        CreateAccountPage.Instance.createAccount(userName, userPassword);

        return userName;
    }

}
