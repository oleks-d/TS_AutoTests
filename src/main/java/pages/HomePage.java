package pages;

import enums.ProductTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by odiachuk on 07.07.17.
 */
public class HomePage extends BasePage{

    private static HomePage instance;
    public static HomePage Instance = (instance != null) ? instance : new HomePage();

    public HomePage(){
        pageURL = "/";
    }
    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

    By shopOurMattressButton = By.xpath("(//a[text()='Shop Our Mattress'])[1]");
    By shopOurMonitorButton = By.xpath("(//a[text()='Shop Our Monitor'])[1]");

    /** Page Methods */

    public MattressesPage clickOnShopOurMattressButton() {
        reporter.info("Click on Shop Our Mattress");
        findElement(shopOurMattressButton).click();
        return MattressesPage.Instance;
    }

    public MonitorPage clickOnShopOurMonitorButton() {
        scrollToElement(driver().findElement(shopOurMonitorButton));
        reporter.info("Click on Shop Our Monitor");
        findElement(shopOurMonitorButton).click();
        return MonitorPage.Instance;
    }
}
