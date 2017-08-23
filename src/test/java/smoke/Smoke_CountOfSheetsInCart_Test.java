package smoke;

import annotations.TestName;
import entities.ItemEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SheetsetPage;
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
        ViewCartPage cart = ViewCartPage.Instance;
        homePage.open();
        ProductSync.check(ProductTypes.SHEETSET);
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        SheetsetPage sheetsetPage = shopPage.clickOnShopSheetsButton();

        //filling the cart with different types and count of sheets
        sheetsetPage.selectSheetsetSize(defaultSheet.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurSheetsButton();
        sheetsetPage.selectSheetsetSize(defaultSheet.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        //checking if items were added and counted normally
        countOfGoodsFromCartIcon = sheetsetPage.header.getCountOfGoodsFromCartIcon();
        countOfGoodsInCart = sheetsetPage.header.getCountOfGoodsInCart();
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");

        shopPage.clickOnShopOurSheetsButton();
        sheetsetPage.selectSheetsetSize(updatedSheet.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurSheetsButton();
        sheetsetPage.selectSheetsetSize(updatedSheet.getSize()).clickAddToCart();
        cart.clickOnBackToShop();

        shopPage.clickOnShopOurSheetsButton();
        sheetsetPage.selectSheetsetSize(updatedSheet.getSize()).clickAddToCart();
        cart.clickOnBackToShop();
        ProductSync.uncheck(ProductTypes.SHEETSET);
        //getting count of selected goods from cart icon
        countOfGoodsFromCartIcon = sheetsetPage.header.getCountOfGoodsFromCartIcon();
        //getting count of selected goods from cart
        countOfGoodsInCart = sheetsetPage.header.getCountOfGoodsInCart();

        //checking if sheets were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
