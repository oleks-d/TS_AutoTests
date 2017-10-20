package viewcart;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;
import utils.ProductSync;

public class ViewCart_UpdateFoamPillowTest extends BaseTest {

    @Test
    @TestName(name="Foam Pillow Update test")
    public void viewCart_UpdateFoamPillowTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_FoamPillow.json") );
        ItemEntity updateditem = item ;//EntitiesFactory.getItem( FileIO.getDataFile("Updated_FoamPillow.json") );

        //init pages
        HomePage home = HomePage.Instance;
        FoamPillowPage prodPage = FoamPillowPage.Instance;
        ViewCartPage cartPage = ViewCartPage.Instance;

        //open home page and add Foam Pillow to cart
        home.open();
        ProductSync.check(ProductTypes.FOAM_PILLOW);
        home.header.clickShopMenuItem()
                .clickOnShopOurFoamPillowButton()
                .clickAddToCart();
        ProductSync.uncheck(ProductTypes.FOAM_PILLOW);
        cartPage.clickOnEditProduct(item.getTitle());

        prodPage
                .clickUpdateCart();

        Assert.assertTrue(cartPage.itemDisplayedOnViewCartPage(updateditem), "Updated item was not displayed");

    }
}
