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

public class ViewCart_UpdateMattressTest extends BaseTest {

    @Test
    @TestName(name="Mattress Update test")
    public void viewCart_UpdateMattressTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_Mattress.json") );
        ItemEntity updateditem = EntitiesFactory.getItem( FileIO.getDataFile("Updated_Mattress.json") );

        //init pages
        HomePage home = HomePage.Instance;
        MattressesPage prodPage = MattressesPage.Instance;
        ViewCartPage cartPage = ViewCartPage.Instance;

        //open home page and add mattress to cart
        home.open();
        ProductSync.check(ProductTypes.MATTRESS);
        home.clickOnShopOurMattressButton()
                .selectMattressSize(item.getSize())
                .selectMattressFeel(item.getType())
                .clickAddToCart();
        ProductSync.uncheck(ProductTypes.MATTRESS);
        cartPage.clickOnEditProduct(item.getTitle());

        prodPage
                .selectMattressSize(updateditem.getSize())
                .selectMattressFeel(updateditem.getType())
                .clickUpdateCart();

        Assert.assertTrue(cartPage.itemDisplayedOnViewCartPage(updateditem), "Updated item was not displayed");

    }
}
