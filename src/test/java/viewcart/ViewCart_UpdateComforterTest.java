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

public class ViewCart_UpdateComforterTest extends BaseTest {

    @Test
    @TestName(name="Comforter Update test")
    public void viewCart_UpdateComforterTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_Comforter.json") );
        ItemEntity updateditem = EntitiesFactory.getItem( FileIO.getDataFile("Updated_Comforter.json") );

        //init pages
        HomePage home = HomePage.Instance;
        ComforterPage prodPage = ComforterPage.Instance;
        ViewCartPage cartPage = ViewCartPage.Instance;

        //open home page and add Comforter to cart
        home.open();
        ProductSync.check(ProductTypes.COMFORTER);
        home.header.clickShopMenuItem()
                .clickOnShopOurComforterButton()
                .selectComforterSize(item.getSize())
                .clickAddToCart();

        ProductSync.uncheck(ProductTypes.COMFORTER);
        cartPage.clickOnEditProduct(item.getTitle());

        prodPage
                .selectComforterSize(updateditem.getSize())
                .clickUpdateCart();

        Assert.assertTrue(cartPage.itemDisplayedOnViewCartPage(updateditem), "Updated item was not displayed");

    }
}
