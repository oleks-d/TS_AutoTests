package smoke;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.CheckoutReviewPage;
import pages.HomePage;
import pages.ViewCartPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;
import utils.ProductSync;

public class Smoke_Sheets_FullTest extends BaseTest {

    @Test
    @TestName(name="Sheets Workflow test")
    public void smoke_Sheets_FullTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_Sheets.json") );
        UserEntity user = EntitiesFactory.getUser( FileIO.getDataFile("Default_User.json")); // get user data from file

        //init pages
        HomePage home = HomePage.Instance;
        ViewCartPage cart = ViewCartPage.Instance;
        CheckoutPage checkout = CheckoutPage.Instance;
        CheckoutReviewPage review = CheckoutReviewPage.Instance;

        //open home page and add Sheets to cart
        home.open();
        ProductSync.check(ProductTypes.SHEETSET);
        home.header.clickShopMenuItem()
                .clickOnShopOurSheetsButton()
                .selectSheetsetSize(item.getSize())
                .clickAddToCart();
        home.header.clickShopMenuItem();

        ProductSync.uncheck(ProductTypes.SHEETSET);
        // check item in cart
        Assert.assertTrue(home.header.itemWasFoundInCart(item),  "Item was not displayed in cart");

        //check item displayed in order
        if (FileIO.getConfigProperty("EnvType").equals("PROD")){
            home.header.clickOnViewCartButton();
            Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed in cart");
            home.header.clickOnCheckoutButton();
            Assert.assertTrue(checkout.itemDisplayedOnCheckoutPage(item), "Item was not displayed in order");
        }

        //check item in full cart
        if (FileIO.getConfigProperty("EnvType").equals("Staging")) {
            home.header.clickOnViewCartButton();
            Assert.assertTrue(cart.itemDisplayedOnViewCartPage(item), "Item was not displayed in cart");
            home.header.clickOnCheckoutButton();
        }

        //set all user related felds
        checkout.populateAllCheckoutFields(user);
        checkout.selectFreeShipping();
        checkout.clickNextButton();

        //check Order Review page was opened
        Assert.assertTrue(review.isPaymentMethodTitleDisplayed(),"Payment page was not displayed");

        //check item in final order
        if (FileIO.getConfigProperty("EnvType").equals("PROD")){
            Assert.assertTrue(review.itemWasFoundInOrder(item), "Item was not displayed on final page");
        }

    }
}
