package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MattressProtectorPage;
import pages.ShopPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * @author Taras
 * @since 7/25/2017.
 */
public class Smoke_CountOfMattressProtectorsInCart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of mattress protectors in cart and the cart flag in header")
    public void countOfMattressesInCart_Test() throws Exception {

        // creating of two system entities
        ItemEntity defaultProtector = EntitiesFactory.getItem(FileIO.getDataFile("Default_Protector.json"));
        ItemEntity updatedProtector = EntitiesFactory.getItem(FileIO.getDataFile("Updated_Protector.json"));

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        //open pages
        HomePage homePage = HomePage.Instance;
        homePage.open();;
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        MattressProtectorPage protectorPage = shopPage.clickOnShopOurCoverButton();

        //adding two the identical "default" protectors to the cart
        protectorPage.selectProtectorSize(defaultProtector.getSize()).selectProtectorSize(defaultProtector.getType()).clickAddToCart();
        protectorPage.selectProtectorSize(defaultProtector.getSize()).selectProtectorSize(defaultProtector.getType()).clickAddToCart();

        //checking if "default" protectors were counted
        countOfGoodsFromCartIcon = protectorPage.header.getCountOfGoodsFromCartIcon();
        countOfGoodsInCart = protectorPage.header.getCountOfGoodsInCart();
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "First time. Count of added to cart items equal to count from cart icon");

        protectorPage.open();

        //adding another "updated" configuration variants of protectors to the cart
        protectorPage.selectProtectorSize(defaultProtector.getSize()).selectProtectorSize(updatedProtector.getType()).clickAddToCart();
        protectorPage.selectProtectorSize(defaultProtector.getSize()).selectProtectorSize(updatedProtector.getType()).clickAddToCart();
        protectorPage.selectProtectorSize(defaultProtector.getSize()).selectProtectorSize(updatedProtector.getType()).clickAddToCart();

        countOfGoodsFromCartIcon = protectorPage.header.getCountOfGoodsFromCartIcon();
        countOfGoodsInCart = protectorPage.header.getCountOfGoodsInCart();

        //checking if count of goods is equal in the cart and on the cart icon
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Second time. Count of added to cart items equal to count from cart icon");
    }

}
