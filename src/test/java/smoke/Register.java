package smoke;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

/**
 * Created by Kos on 7/17/17.
 */
public class Register extends BaseTest{

    @Test
    public void RegisterNewUser(){

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;

    }

}

