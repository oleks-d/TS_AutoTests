package smoke;

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
                {ProductTypes.MONITOR, MonitorPage.class},
                {ProductTypes.MATTRESS, MattressesPage.class},
                {ProductTypes.MATTRESS_PROTECTOR, MattressProtectorPage.class},
                {ProductTypes.COMFORTER, ComforterPage.class},
                {ProductTypes.PLUSH_PILLOW, PlushPillowPage.class},
                {ProductTypes.FOAM_PILLOW, FoamPillowPage.class},
                {ProductTypes.DRAPES, DrapesPage.class},
                {ProductTypes.SHEETSET, SheetsetPage.class},
        };
    }


    @Test (dataProvider = "provider")
    public void addMattressToCart_GeneralValidationTest(ProductTypes type, Class page) throws Exception {

        HomePage home = HomePage.Instance;
        CheckoutPage checkout = CheckoutPage.Instance;
        CheckoutReviewPage review = CheckoutReviewPage.Instance;
        BasePage bp = (BasePage) page.getConstructor().newInstance();


        home.open();


    }
}
