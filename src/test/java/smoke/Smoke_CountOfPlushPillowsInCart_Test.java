package smoke;

import annotations.TestName;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PlushPillowPage;
import pages.ShopPage;
import pages.ViewCartPage;
import utils.BaseTest;
import utils.ProductSync;

/**
 * @author Taras
 * @since 7/25/2017.
 */
public class Smoke_CountOfPlushPillowsInCart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of plush pillows in cart and cart flag in header")
    public void countOfPlushPillowsInCart_Test() throws Exception {

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        //open pages
        HomePage homePage = HomePage.Instance;
        ViewCartPage cart = ViewCartPage.Instance;
        homePage.open();
        ProductSync.check(ProductTypes.PLUSH_PILLOW);
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        PlushPillowPage plushPillowPage = shopPage.clickOnShopOurPlushPillowButton();

        //adding three the identical plush pillows to the cart
        plushPillowPage.clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurPlushPillowButton();
        plushPillowPage.clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurPlushPillowButton();
        plushPillowPage.clickAddToCart();
        cart.clickOnBackToShop();
        ProductSync.uncheck(ProductTypes.PLUSH_PILLOW);
        //getting count from cart icon
        countOfGoodsFromCartIcon = plushPillowPage.header.getCountOfGoodsFromCartIcon();
        //getting count from cart
        countOfGoodsInCart = plushPillowPage.header.getCountOfGoodsInCart();

        //checking if plush pillows was added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
