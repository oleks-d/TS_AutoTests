package smoke;

import annotations.TestName;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.ProductSync;

import javax.swing.text.View;

/**
 * @author Taras
 * @since 7/27/2017.
 */
public class Smoke_CountOfFoamPillowsInCart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of foam pillows in cart and cart flag in header")
    public void countOfFoamPillowsInCart_Test() throws Exception {

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        HomePage homePage = HomePage.Instance;
        ViewCartPage cart = ViewCartPage.Instance;
        homePage.open();
        ProductSync.check(ProductTypes.FOAM_PILLOW);
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        FoamPillowPage foamPillowPage = shopPage.clickOnShopOurFoamPillowButton();

        //adding three the identical foam pillows to the cart
        foamPillowPage.clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurFoamPillowButton();
        foamPillowPage.clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurFoamPillowButton();
        foamPillowPage.clickAddToCart();
        cart.clickOnBackToShop();

        ProductSync.uncheck(ProductTypes.FOAM_PILLOW);

        //getting count from cart icon
        countOfGoodsFromCartIcon = foamPillowPage.header.getCountOfGoodsFromCartIcon();
        //getting count from cart
        countOfGoodsInCart = foamPillowPage.header.getCountOfGoodsInCart();

        //checking if foam pillows were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
