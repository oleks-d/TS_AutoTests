package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MattressesPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * @author Taras
 * @since 7/25/2017.
 */
public class CountOfGoods_Test extends BaseTest {

    String biggerMattressSize = "Full";
    String biggerMattressFeel = "Medium Soft";

    String smallerMattressSize = "Twin";
    String smallerMattressFeel = "Medium Firm";


    @Test
    @TestName(name = "Check count of goods in cart and cart flag in header")
    public void countOfGoods_Test() throws Exception {

        // creating of two system entities
        ItemEntity biggerMattress = EntitiesFactory.getItem(FileIO.getDataFile("Default_Mattress.json"));
        ItemEntity smallerMattress = EntitiesFactory.getItem(FileIO.getDataFile("Updated_Mattress.json"));

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        MattressesPage mattressesPage = MattressesPage.Instance;
        mattressesPage.open();
        //adding two the identical "bigger" mattresses to the cart
        mattressesPage.selectMattressSize(biggerMattress.getSize()).selectMattressFeel(biggerMattress.getType()).clickAddToCart();
        mattressesPage.selectMattressSize(biggerMattress.getSize()).selectMattressFeel(biggerMattress.getType()).clickAddToCart();

        //checking if "bigger" mattresses were counted
//        countOfGoodsFromCartIcon = mattressesPage.header.getCountOfGoodsFromCartIcon();
//        countOfGoodsInCart = mattressesPage.header.getCountOfGoodsInCart(biggerMattress, smallerMattress);
//        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "First time. Count of added to cart items equal to count from cart icon");

        //adding another item (model of smaller mattresses) to the cart
        mattressesPage.open();
        mattressesPage.selectMattressSize(smallerMattress.getSize()).selectMattressFeel(smallerMattress.getType()).clickAddToCart();
        mattressesPage.selectMattressSize(smallerMattress.getSize()).selectMattressFeel(smallerMattress.getType()).clickAddToCart();
        mattressesPage.selectMattressSize(smallerMattress.getSize()).selectMattressFeel(smallerMattress.getType()).clickAddToCart();

        countOfGoodsFromCartIcon = mattressesPage.header.getCountOfGoodsFromCartIcon();
        countOfGoodsInCart = mattressesPage.header.getCountOfGoodsInCart(biggerMattress, smallerMattress);

        //checking if "smaller" mattress was added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Second time. Count of added to cart items equal to count from cart icon");
    }

}
