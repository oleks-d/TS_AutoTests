package viewcart;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

public class ViewCart_UpdateDrapesTest extends BaseTest {

    @Test
    @TestName(name="Drapes Update test")
    public void viewCart_UpdateDrapesTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_Drapes.json") );
        ItemEntity updateditem = EntitiesFactory.getItem( FileIO.getDataFile("Updated_Drapes.json") );

        //init pages
        HomePage home = HomePage.Instance;
        DrapesPage prodPage = DrapesPage.Instance;
        ViewCartPage cartPage = ViewCartPage.Instance;

        //open home page and add Drapes to cart
        home.open();
        home.header.clickShopMenuItem()
                .clickOnShopOurDrapesButton()
                .selectDrapesSize(item.getSize())
                .selectDrapesColor(item.getType())
                .clickAddToCart();

        home.header.clickOnViewCartButton().clickOnEditProduct(item.getTitle());

        prodPage
                .selectDrapesSize(updateditem.getSize())
                .selectDrapesColor(updateditem.getType())
                .clickUpdateCart();

        Assert.assertTrue(cartPage.itemDisplayedOnViewCartPage(updateditem), "Updated item was not displayed");

    }
}
