package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
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
    public void smoke_DeleteItemFromCartTest() throws Exception {

        //getting default entity
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_FoamPillow.json") );

        //Page initializing
        HomePage home = HomePage.Instance;
        home.open();

        //adding item to the cart
        home.clickOnShopFoamPillowButton().clickAddToCart();

        //checking that added items were displayed
        Assert.assertTrue(home.header.itemWasFoundInCart(item),  "Item was displayed in cart");

        //deleting item from cart
        home.header.clickOnDeleteCartButton(item);

        //checking that item was deleted from the cart
        Assert.assertFalse(home.header.itemWasFoundInCart(item),  "Item was deleted from cart");
    }
}
