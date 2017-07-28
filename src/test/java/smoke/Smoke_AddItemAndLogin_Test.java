package smoke;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MattressesPage;
import pages.ShopPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * @author Taras
 * @since 7/27/2017.
 */
public class Smoke_AddItemAndLogin_Test extends BaseTest {

    @Test
    @TestName(name = "add item to cart, log in, item must still in the cart")
    public void addItemAndLogin_Test() throws Exception {

        // creation of system entities
        ItemEntity mattress = EntitiesFactory.getItem(FileIO.getDataFile("Updated_Mattress.json"));
        UserEntity user = EntitiesFactory.getUser(FileIO.getDataFile("AccTest_User.json"));

        //open pages
        HomePage homePage = HomePage.Instance;
        homePage.open();
        ;
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        MattressesPage mattressesPage = shopPage.clickOnShopOurMattressButton();

        //add mattress to the cart
        mattressesPage.selectMattressSize(mattress.getSize()).selectMattressFeel(mattress.getType()).clickAddToCart();

        ///back to home page
        homePage.open();

        //try to sign in
        homePage.header.clickSignInMenuItem();
        LoginPage login = LoginPage.Instance;
        login.enterUsername(user.getUsername());
        login.enterPassword(user.getPassword());
        AccountPage accountPage = login.submitForm();

        //Chech that cart contains such mattress after signing in
        Assert.assertTrue(accountPage.header.validateItemContentByTitle(ProductTypes.MATTRESS.toString(), mattress.getType()), "Expected Mattress was not found in Cart");

    }

}

