package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComforterPage;
import pages.HomePage;
import pages.ShopPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

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
        homePage.open();
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        ComforterPage comforterPage = shopPage.clickOnShopComforterButton();

        //filling the cart with different types and counts of comforters
        comforterPage.selectComforterSize(defaultComforter.getSize()).clickAddToCart();
        comforterPage.selectComforterSize(defaultComforter.getSize()).clickAddToCart();

        //getting count of selected goods from cart icon
        countOfGoodsFromCartIcon = comforterPage.header.getCountOfGoodsFromCartIcon();
        //getting count of selected goods from cart
        countOfGoodsInCart = comforterPage.header.getCountOfGoodsInCart();

        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");

        comforterPage.selectComforterSize(updatedComforter.getSize()).clickAddToCart();
        comforterPage.selectComforterSize(updatedComforter.getSize()).clickAddToCart();
        comforterPage.selectComforterSize(updatedComforter.getSize()).clickAddToCart();

        //getting count of selected goods from cart icon
        countOfGoodsFromCartIcon = comforterPage.header.getCountOfGoodsFromCartIcon();
        //getting count of selected goods from cart
        countOfGoodsInCart = comforterPage.header.getCountOfGoodsInCart();

        //checking if comforters were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
