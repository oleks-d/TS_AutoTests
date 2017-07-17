package smoke;

import annotations.TestName;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DrapesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;
import utils.BaseTest;
import pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.net.URL;

import static pages.BasePage.driver;

public class AlexSmoke_AddDrapesToCart extends BaseTest {

    String drapesSize = "84 Inches Height";
    String drapesColor = "Blue";
    By shopOurDrapesButton = By.xpath("(//a[text()='SHOP OUR DRAPES'])[1]");

    @Test
    public void addMattressToCart_GeneralValidationTest(){

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();
        home.header.clickShopMenuItem();
        ShopPage shop = ShopPage.Instance;
//        shop.goToDrapes();
        //scrollToElement(shopOurDrapesButton).shopOurDrapesButton();
        shop.clickOnShopOurDrapesButton();
        DrapesPage drapes = DrapesPage.Instance;

//                .selectMattressSize(mattressSize)
//                .selectMattressFeel(mattressFeel)
//                .clickAddToCart();



//        drapes.click()
//                .selectMonitorType(monitorType)
//                .clickAddToCart();

        // Assert.assertTrue( home.header.validateMattressInCart(mattressSize, mattressFeel) , "Expected Mattress was not found in Cart");


    }

}
