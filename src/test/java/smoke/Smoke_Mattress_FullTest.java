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

public class Smoke_Mattress_FullTest extends BaseTest {

    @Test
    @TestName(name="Mattress Workflow test")
    public void smoke_Mattress_FullTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_Mattress.json") );
        UserEntity user = EntitiesFactory.getUser( FileIO.getDataFile("Default_User.json")); // get user data from file

        //init pages
        HomePage home = HomePage.Instance;
        ViewCartPage cart = ViewCartPage.Instance;
        CheckoutPage checkout = CheckoutPage.Instance;
        CheckoutReviewPage review = CheckoutReviewPage.Instance;

        //open home page and add mattress to cart
        home.open();
        ProductSync.check(ProductTypes.MATTRESS);
        home.clickOnShopOurMattressButton()
                .selectMattressSize(item.getSize())
                .selectMattressFeel(item.getType())
                .clickAddToCart();
        cart.clickOnBackToShop();

        ProductSync.uncheck(ProductTypes.MATTRESS);
        // check item in cart
        Assert.assertTrue(home.header.itemWasFoundInCart(item),  "Item was not displayed in cart");

        home.header.clickOnCheckoutButton();

        //check item displayed in order
        Assert.assertTrue(checkout.itemDisplayedOnCheckoutPage(item), "Item was not displayed in order");

        //set all user related felds
        checkout.populateAllCheckoutFields(user);
        checkout.selectFreeShipping();
        checkout.clickNextButton();

        //check Order Review page was opened
        Assert.assertTrue(review.isPaymentMethodTitleDisplayed(),"Payment page was not displayed");

        //check item in final order
        Assert.assertTrue(review.itemWasFoundInOrder(item), "Item was not displayed on final page");

    }
}
