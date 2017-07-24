package old;

import entities.ItemEntity;
import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MattressesPage;
import utils.BaseTest;

public class AddMattressToCart_GeneralValidationTest extends BaseTest {

    String mattressSize = "Full";
    String mattressFeel = "Medium Soft";
    int qty = 1;
    float price = 800;

    @Test()
    public void addMattressToCart_GeneralValidationTest(){

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

       home.open();
       home.clickOnShopOurMattressButton()
            .selectMattressSize(mattressSize)
            .selectMattressFeel(mattressFeel)
            .clickAddToCart();

        //validation new way
        ItemEntity item = new ItemEntity(ProductTypes.MATTRESS.getValue(), price, qty, mattressSize, mattressFeel);
        Assert.assertTrue(home.header.itemWasFoundInCart(item));

        //validation old way
        Assert.assertTrue( home.header.validateItemContentByTitle(ProductTypes.MATTRESS.toString(), mattressSize, mattressFeel), "Expected Mattress was not found in Cart");

    }

}
