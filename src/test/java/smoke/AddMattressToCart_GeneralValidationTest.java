package smoke;

import enums.ProductTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

public class AddMattressToCart_GeneralValidationTest extends BaseTest {

    String mattressSize = "Full";
    String mattressFeel = "Medium Soft";

    @Test
    public void addMattressToCart_GeneralValidationTest(){

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();
        home.clickOnShopOurMattressButton()
        .selectMattressSize(mattressSize)
        .selectMattressFeel(mattressFeel)
        .clickAddToCart();


        //Assert.assertTrue( home.header.validateMattressInCart(mattressSize, mattressFeel) , "Expected Mattress was not found in Cart");
        Assert.assertTrue( home.header.validateItemContentByTitle(ProductTypes.MATTRESS.toString(), mattressSize, mattressFeel), "Expected Mattress was not found in Cart");

    }

}
