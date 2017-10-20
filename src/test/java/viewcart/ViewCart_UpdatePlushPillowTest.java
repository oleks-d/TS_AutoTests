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

public class ViewCart_UpdatePlushPillowTest extends BaseTest {

    @Test
    @TestName(name="Plush Pillow Update test")
    public void viewCart_UpdatePlushPillowTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_PlushPillow.json") );
        ItemEntity updateditem = item; //EntitiesFactory.getItem( FileIO.getDataFile("Updated_PlushPillow.json") );

        //init pages
        HomePage home = HomePage.Instance;
        PlushPillowPage prodPage = PlushPillowPage.Instance;
        ViewCartPage cartPage = ViewCartPage.Instance;

        //open home page and add Plush Pillow to cart
        home.open();
        ProductSync.check(ProductTypes.PLUSH_PILLOW);
        home.header.clickShopMenuItem()
                .clickOnShopOurPlushPillowButton()
                .clickAddToCart();
        ProductSync.uncheck(ProductTypes.PLUSH_PILLOW);
        cartPage.clickOnEditProduct(item.getTitle());

        prodPage
                .clickUpdateCart();

        Assert.assertTrue(cartPage.itemDisplayedOnViewCartPage(updateditem), "Updated item was not displayed");

    }
}
