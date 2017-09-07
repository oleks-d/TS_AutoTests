package smoke;

import annotations.TestName;
import entities.ItemEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComforterPage;
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
public class Smoke_CountOfComfortersInCart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of comforters in cart and cart flag in header")
    public void countOfComfortersInCart_Test() throws Exception {

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        //init test entities
        ItemEntity defaultComforter = EntitiesFactory.getItem(FileIO.getDataFile("Default_Comforter.json"));
        ItemEntity updatedComforter = EntitiesFactory.getItem(FileIO.getDataFile("Updated_Comforter.json"));

        //Pages initializing
        HomePage homePage = HomePage.Instance;
        ViewCartPage cart = ViewCartPage.Instance;
        homePage.open();
        ProductSync.check(ProductTypes.COMFORTER);
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        ComforterPage comforterPage = shopPage.clickOnShopComforterButton();

        //filling the cart with different types and counts of comforters
        comforterPage.selectComforterSize(defaultComforter.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurComforterButton();
        comforterPage.selectComforterSize(defaultComforter.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        //getting count of selected goods from cart icon
        countOfGoodsFromCartIcon = comforterPage.header.getCountOfGoodsFromCartIcon();
        //getting count of selected goods from cart
        countOfGoodsInCart = comforterPage.header.getCountOfGoodsInCart();


        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");

        shopPage.clickOnShopOurComforterButton();
        comforterPage.selectComforterSize(updatedComforter.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurComforterButton();
        comforterPage.selectComforterSize(updatedComforter.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurComforterButton();
        comforterPage.selectComforterSize(updatedComforter.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        ProductSync.uncheck(ProductTypes.COMFORTER);

        //getting count of selected goods from cart icon
        countOfGoodsFromCartIcon = comforterPage.header.getCountOfGoodsFromCartIcon();
        //getting count of selected goods from cart
        countOfGoodsInCart = comforterPage.header.getCountOfGoodsInCart();

        //checking if comforters were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
