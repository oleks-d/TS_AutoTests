package viewcart;

import annotations.TestName;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.ProductSync;

public class ViewCart_DeleteTest extends BaseTest {

    @DataProvider(name = "default_item_provider")
    public Object[][] provider () throws Exception {
        return new Object[][]{
                {ProductTypes.MATTRESS, MattressesPage.class, "Mattress" },
                {ProductTypes.MATTRESS_PROTECTOR, MattressProtectorPage.class, "Protector" },
                {ProductTypes.COMFORTER,  ComforterPage.class, "Comforter"},
                {ProductTypes.PLUSH_PILLOW, PlushPillowPage.class, "Plush Pillow"},
                {ProductTypes.FOAM_PILLOW,  FoamPillowPage.class, "Foam Pillow"},
                {ProductTypes.DRAPES, DrapesPage.class, "Drapes"},
                {ProductTypes.SHEETSET, SheetsetPage.class, "Sheets"},
                {ProductTypes.MONITOR, MonitorPage.class, "Monitor"}

//                {ProductTypes.MONITOR, MonitorPage.class, "Monitor"},
//                {ProductTypes.MATTRESS, MattressesPage.class, "Mattress" },
//                {ProductTypes.MATTRESS_PROTECTOR, MattressProtectorPage.class, "Protector" },
//                {ProductTypes.COMFORTER, ComforterPage.class, "Comforter"},
//                {ProductTypes.PLUSH_PILLOW, PlushPillowPage.class, "Plush Pillow"},
//                {ProductTypes.FOAM_PILLOW, FoamPillowPage.class, "Foam Pillow"},
//                {ProductTypes.DRAPES, DrapesPage.class, "Drapes"},
//                {ProductTypes.SHEETSET, SheetsetPage.class, "Sheets"},
        };
    }


    @Test(dataProvider="default_item_provider")
    @TestName(name = "Delete Item from Cart")
    public void viewCart_Delete_Test(ProductTypes type, Class page, String itemMenuName) throws Exception {

        //init pages
        HomePage home = HomePage.Instance;
        ViewCartPage viewcart = ViewCartPage.Instance;

        BaseProductPage bp = (BaseProductPage) page.getConstructor().newInstance();

        home.open();
        ProductSync.check(type);
        home.header.openMenuByItemName(itemMenuName);

        Assert.assertTrue(bp.isPageLoaded(), "Page was not opened: " + bp.getURL());

        if (type == ProductTypes.MONITOR) // no default value for monitor - user have to select type before Adding to cart
            MonitorPage.Instance.selectMonitorType("One Person");

        bp.clickAddToCart();

        home.header.clickOnViewCartButton();

        // check item in viewcart
        Assert.assertTrue(viewcart.itemDisplayedOnViewCartPage(type.toString()),  "Item was not displayed in cart");

        viewcart.clickOnDeleteProduct(type.toString());

        ProductSync.uncheck(type);

        Assert.assertTrue(!viewcart.itemDisplayedOnViewCartPage(type.toString()),  "Item was displayed in cart");

    }
}
