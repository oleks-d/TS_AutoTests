package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.BaseProductPage;
import pages.HomePage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * @author Taras
 * @since 7/24/2017.
 */
public class Smoke_DeleteItemFromCartTest extends BaseTest {

    @Test
    @TestName(name="Delete Item From Cart Workflow test")
    public void Smoke_DeleteItemFromCartTest() throws Exception {

        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_FoamPillow.json") );

        HomePage home = HomePage.Instance;

        home.open();
        home.clickOnShopFoamPillowButton().clickAddToCart();

        org.testng.Assert.assertTrue(home.header.itemWasFoundInCart(item),  "Item was not displayed in cart");

        home.header.clickOnDeleteCartButton(item);

        org.testng.Assert.assertFalse(home.header.itemWasFoundInCart(item),  "Item was deleted from cart");
    }
}
