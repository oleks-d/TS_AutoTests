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

public class ViewCart_UpdateProtectorTest extends BaseTest {

    @Test
    @TestName(name="Protector Update test")
    public void viewCart_UpdateProtectorTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_Protector.json") );
        ItemEntity updateditem = EntitiesFactory.getItem( FileIO.getDataFile("Updated_Protector.json") );

        //init pages
        HomePage home = HomePage.Instance;
        MattressProtectorPage prodPage = MattressProtectorPage.Instance;
        ViewCartPage cartPage = ViewCartPage.Instance;

        //open home page and add Protector to cart
        home.open();
        ProductSync.check(ProductTypes.MATTRESS_PROTECTOR);
        home.header.clickShopMenuItem()
                .clickOnShopOurCoverButton()
                .selectProtectorSize(item.getSize())
                .clickAddToCart();
        ProductSync.uncheck(ProductTypes.MATTRESS_PROTECTOR);
        cartPage.clickOnEditProduct(item.getTitle());

        prodPage
                .selectProtectorSize(updateditem.getSize())
                .clickUpdateCart();

        Assert.assertTrue(cartPage.itemDisplayedOnViewCartPage(updateditem), "Updated item was not displayed");
    }
}
