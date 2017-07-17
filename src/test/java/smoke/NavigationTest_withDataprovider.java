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

public class NavigationTest_withDataprovider extends BaseTest {

    @DataProvider(name = "provider")
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


    @Test (dataProvider = "provider")
    public void topMenuValidation(ProductTypes type, Class page, String itemName) throws Exception {

        HomePage home = HomePage.Instance;
        CheckoutPage checkout = CheckoutPage.Instance;
        CheckoutReviewPage review = CheckoutReviewPage.Instance;
        BasePage bp = (BasePage) page.getConstructor().newInstance();

        home.open();
        home.header.openMenuByItemName(itemName);

        Assert.assertTrue(bp.isPageLoaded(), "Page was not opened: " + bp.getURL());

    }
}
