package smoke;

import annotations.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FoamPillowPage;
import pages.HomePage;
import utils.BaseTest;

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
        homePage.open();
        FoamPillowPage foamPillowPage = homePage.clickOnShopFoamPillowButton();

        //adding three the identical foam pillows to the cart
        foamPillowPage.clickAddToCart();
        foamPillowPage.clickAddToCart();
        foamPillowPage.clickAddToCart();

        //getting count from cart icon
        countOfGoodsFromCartIcon = foamPillowPage.header.getCountOfGoodsFromCartIcon();
        //getting count from cart
        countOfGoodsInCart = foamPillowPage.header.getCountOfGoodsInCart();

        //checking if foam pillows were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
