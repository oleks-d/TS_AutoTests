package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MonitorPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * @author Taras
 * @since 7/27/2017.
 */
public class Smoke_CountOfSleepTrackersInCart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of sleep trackers in cart and cart flag in header")
    public void countOfSleepTrackersInCart_Test() throws Exception {

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        //init test entities
        ItemEntity defaultMonitor = EntitiesFactory.getItem(FileIO.getDataFile("Default_Monitor.json"));
        ItemEntity updatedMonitor = EntitiesFactory.getItem(FileIO.getDataFile("Updated_Monitor.json"));

        //Pages initializing
        HomePage homePage = HomePage.Instance;
        homePage.open();
        MonitorPage monitorPage = homePage.header.clickShopMenuItem().clickOnShopOurMonitorButton();

        //filling the cart with different types and counts of sleep trackers
        monitorPage.selectMonitorType(defaultMonitor.getType()).clickAddToCart();
        monitorPage.selectMonitorType(defaultMonitor.getType()).clickAddToCart();
        monitorPage.selectMonitorType(defaultMonitor.getType()).clickAddToCart();

        monitorPage.selectMonitorType(updatedMonitor.getType()).clickAddToCart();
        monitorPage.selectMonitorType(updatedMonitor.getType()).clickAddToCart();

        //getting count of selected sleep trackers from cart icon
        countOfGoodsFromCartIcon = monitorPage.header.getCountOfGoodsFromCartIcon();
        //getting count of selected sleep trackers from cart
        countOfGoodsInCart = monitorPage.header.getCountOfGoodsInCart();

        //checking if sleep trackers were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Count of added to cart items equal to count from cart icon");
    }

}
