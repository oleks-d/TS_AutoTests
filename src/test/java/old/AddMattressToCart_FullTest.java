package old;

import account.SetupProcedures;
import entities.ItemEntity;
import entities.UserEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.CheckoutReviewPage;
import pages.HomePage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

public class AddMattressToCart_FullTest extends BaseTest {

    String mattressSize = "Full";
    String mattressFeel = "Medium Soft";
    int qty = 1;

    String userDataFile =  FileIO.getConfigProperty("DefaultUser"); // file name from properties

    @Test
    public void addMattressToCart_GeneralValidationTest() throws Exception {

        //ItemEntity item = new ItemEntity(ProductTypes.MATTRESS.getValue(), price, qty, mattressSize, mattressFeel);

        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_Mattress.json") );

        //get user data from file
        UserEntity user = EntitiesFactory.getUser(
                    FileIO.getDataFile(userDataFile));

        HomePage home = HomePage.Instance;
        CheckoutPage checkout = CheckoutPage.Instance;
        CheckoutReviewPage review = CheckoutReviewPage.Instance;


        home.open();

        home.clickOnShopOurMattressButton()
                .selectMattressSize(mattressSize)
                .selectMattressFeel(mattressFeel)
                .clickAddToCart()
                .header.clickOnCheckoutButton();

        Assert.assertTrue(checkout.itemDisplayedOnCheckoutPage(item));

        checkout.populateAllCheckoutFields(user);
        checkout.clickNextButton();

        Assert.assertTrue(review.isPaymentMethodTitleDisplayed(),"Payment page was not displayed");

        Assert.assertTrue(review.itemWasFoundInOrder(item));

    }
}
