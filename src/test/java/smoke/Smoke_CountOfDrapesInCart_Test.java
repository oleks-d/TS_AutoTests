package smoke;

import annotations.TestName;
import entities.ItemEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DrapesPage;
import pages.HomePage;
import pages.ShopPage;
import pages.ViewCartPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;
import utils.ProductSync;

/**
 * @author Taras
 * @since 7/27/2017.
 */
public class Smoke_CountOfDrapesInCart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of drapes in cart and cart flag in header")
    public void countOfSheetsInCart_Test() throws Exception {

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        //creating system entities
        ItemEntity defaultSheet = EntitiesFactory.getItem(FileIO.getDataFile("Default_Drapes.json"));
        ItemEntity updatedSheet = EntitiesFactory.getItem(FileIO.getDataFile("Updated_Drapes.json"));

        //Pages initializing
        HomePage homePage = HomePage.Instance;
        ViewCartPage cart = ViewCartPage.Instance;
        homePage.open();
        ProductSync.check(ProductTypes.DRAPES);
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        DrapesPage drapesPage= shopPage.clickOnShopOurDrapesButton();

        //filling the cart with different types and count of drapes
        drapesPage.selectDrapesColor(defaultSheet.getType()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurDrapesButton();
        drapesPage.selectDrapesColor(defaultSheet.getType()).clickAddToCart();
        cart.clickOnBackToShop();

        //checking if items were added and counted normally
        countOfGoodsFromCartIcon = drapesPage.header.getCountOfGoodsFromCartIcon();
        countOfGoodsInCart = drapesPage.header.getCountOfGoodsInCart();
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");


        shopPage.clickOnShopOurDrapesButton();
        drapesPage.selectDrapesColor(updatedSheet.getType()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurDrapesButton();
        drapesPage.selectDrapesColor(updatedSheet.getType()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurDrapesButton();
        drapesPage.selectDrapesColor(updatedSheet.getType()).clickAddToCart();
        cart.clickOnBackToShop();

        ProductSync.uncheck(ProductTypes.DRAPES);
        //getting count of selected goods from cart icon
        countOfGoodsFromCartIcon = drapesPage.header.getCountOfGoodsFromCartIcon();
        //getting count of selected goods from cart
        countOfGoodsInCart = drapesPage.header.getCountOfGoodsInCart();

        //checking if drapes were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
