package smoke;

import entities.UserEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutReviewPage;
import pages.HomePage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

public class AddMattressToCart_FullTest extends BaseTest {

    String mattressSize = "Full";
    String mattressFeel = "Medium Soft";
    String userDataFile =  FileIO.getConfigProperty("DefaultUser"); // file name from properties


    @Test
    public void addMattressToCart_GeneralValidationTest() throws Exception {

        //get user data from file
        UserEntity user = EntitiesFactory.getUser(
                    FileIO.getDataFile(userDataFile));

        HomePage home = HomePage.Instance;

        home.open();

                home.clickOnShopOurMattressButton()
                .selectMattressSize(mattressSize)
                .selectMattressFeel(mattressFeel)
                .clickAddToCart()
                .header.clickOnCheckoutButton()
                .populateAllCheckoutFields(user)
                .clickNextButton();

        Assert.assertTrue(CheckoutReviewPage.Instance.isPaymentMethodTitleDisplayed(),"Payment page was not displayed");


    }
}
