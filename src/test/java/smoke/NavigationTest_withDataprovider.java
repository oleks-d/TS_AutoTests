package smoke;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;
import utils.ProductSync;

public class NavigationTest_withDataprovider extends BaseTest {

    @DataProvider(name = "default_item_provider")
    public Object[][] provider (){
        return new Object[][]{
                {ProductTypes.MONITOR, MonitorPage.class, "Monitor"},
                {ProductTypes.MATTRESS, MattressesPage.class, "Mattress" },
                {ProductTypes.MATTRESS_PROTECTOR, MattressProtectorPage.class, "Protector" },
                {ProductTypes.COMFORTER, ComforterPage.class, "Comforter"},
                {ProductTypes.PLUSH_PILLOW, PlushPillowPage.class, "Plush Pillow"},
                {ProductTypes.FOAM_PILLOW, FoamPillowPage.class, "Foam Pillow"},
                {ProductTypes.DRAPES, DrapesPage.class, "Drapes"},
                {ProductTypes.SHEETSET, SheetsetPage.class, "Sheets"},
        };
    }

    @Test (dataProvider = "default_item_provider")
    @TestName (name="Navigation validation")
    public void topMenuValidation(ProductTypes type, Class page, String itemName) throws Exception {

        HomePage home = HomePage.Instance;
        CheckoutPage checkout = CheckoutPage.Instance;
        CheckoutReviewPage review = CheckoutReviewPage.Instance;
        BaseProductPage bp = (BaseProductPage) page.getConstructor().newInstance();

        home.open();
        ProductSync.check(type);
        home.header.openMenuByItemName(itemName);

        Assert.assertTrue(bp.isPageLoaded(), "Page was not opened: " + bp.getURL());

        if (type == ProductTypes.MONITOR) // no default value for monitor - user have to select type before Adding to cart
            MonitorPage.Instance.selectMonitorType("One Person");

        bp.clickAddToCart();
        ProductSync.uncheck(type);

        ViewCartPage cart = home.header.clickOnViewCartButton();
        cart.clickOnProduct(type.toString());

        Assert.assertTrue(bp.isPageLoaded(), "Page was not opened: " + bp.getURL());

    }
}
