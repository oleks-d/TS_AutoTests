package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FoamPillowPage;
import pages.HomePage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * @author Taras
 * @since 7/25/2017.
 */
public class Smoke_CountOfFoamPillowsInCart_Test extends BaseTest {

    String biggerMattressSize = "Full";
    String biggerMattressFeel = "Medium Soft";

    String smallerMattressSize = "Twin";
    String smallerMattressFeel = "Medium Firm";


    @Test
    @TestName(name = "Check count of goods in cart and cart flag in header")
    public void countOfFoamPillowsInCart_Test() throws Exception {

        // creating entity
        ItemEntity foamPillow = EntitiesFactory.getItem(FileIO.getDataFile("Default_FoamPillow.json"));

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        HomePage homePage = HomePage.Instance;
        homePage.open();
        FoamPillowPage foamPillowPage = homePage.clickOnShopFoamPillowButton();

        //adding three the identical pillows to the cart
        foamPillowPage.clickAddToCart();
        foamPillowPage.clickAddToCart();
        foamPillowPage.clickAddToCart();

        //getting count from cart icon
        countOfGoodsFromCartIcon = foamPillowPage.header.getCountOfGoodsFromCartIcon();
        //getting count from cart
        countOfGoodsInCart = foamPillowPage.header.getCountOfGoodsInCart();

        //checking if "smaller" mattress was added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
