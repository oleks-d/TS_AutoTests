package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SheetsetPage;
import pages.ShopPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * @author Taras
 * @since 7/27/2017.
 */
public class Smoke_CountOfSheetsInCart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of sheets in cart and cart flag in header")
    public void countOfSheetsInCart_Test() throws Exception {

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        //creating system entities
        ItemEntity defaultSheet = EntitiesFactory.getItem(FileIO.getDataFile("Default_Sheets.json"));
        ItemEntity updatedSheet = EntitiesFactory.getItem(FileIO.getDataFile("Updated_Sheets.json"));

        //Pages initializing
        HomePage homePage = HomePage.Instance;
        homePage.open();
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        SheetsetPage sheetsetPage = shopPage.clickOnShopSheetsButton();

        //filling the cart with different types and count of sheets
        sheetsetPage.selectSheetsetSize(defaultSheet.getSize()).clickAddToCart();
        sheetsetPage.selectSheetsetSize(defaultSheet.getSize()).clickAddToCart();

        //checking if items were added and counted normally
        countOfGoodsFromCartIcon = sheetsetPage.header.getCountOfGoodsFromCartIcon();
        countOfGoodsInCart = sheetsetPage.header.getCountOfGoodsInCart();
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");


        sheetsetPage.selectSheetsetSize(updatedSheet.getSize()).clickAddToCart();
        sheetsetPage.selectSheetsetSize(updatedSheet.getSize()).clickAddToCart();
        sheetsetPage.selectSheetsetSize(updatedSheet.getSize()).clickAddToCart();

        //getting count of selected goods from cart icon
        countOfGoodsFromCartIcon = sheetsetPage.header.getCountOfGoodsFromCartIcon();
        //getting count of selected goods from cart
        countOfGoodsInCart = sheetsetPage.header.getCountOfGoodsInCart();

        //checking if sheets were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
