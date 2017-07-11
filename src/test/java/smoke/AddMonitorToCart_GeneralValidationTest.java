package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

//@Listeners(GenerateReport.class)
public class AddMonitorToCart_GeneralValidationTest extends BaseTest {

    String correctPassword = "bettersleep";
    String monitorType = "One Person";

    @Test
    public void addMonitorToCart_GeneralValidationTest(){

        HomePage home = HomePage.Instance; //login.doLogin(correctPassword);

        home.open();
        home.clickOnShopOurMonitorButton()
            .selectMonitorType(monitorType)
            .clickAddToCart();

        Assert.assertTrue( home.validateMonitorInCart(monitorType) , "Expected Monitor was not found in Cart");


    }

}
