package smoke;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;
import pages.PageHeader;

import static pages.BasePage.driver;

public class KosSmoke_GeneralValidationTest extends BaseTest {

    String username = "qazxsw@mailinator.com";
    String password = "!@qwASzx";



    @Test
    public void userSignIn_GeneralValidationTest(){

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();

        home.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(username);
        login.enterPassword(password);
        login.submitForm();

        AccountPage account = AccountPage.Instance;
        account.getWebElement(By.xpath("//span[text()='Contact Information']/../..//div/p"));



//        home.clickOnShopOurMattressButton()
//        .selectMattressSize(mattressSize)
//        .selectMattressFeel(mattressFeel)
//        .clickAddToCart();



       // Assert.assertTrue( home.header.validateMattressInCart(mattressSize, mattressFeel) , "Expected Mattress was not found in Cart");


    }

}
