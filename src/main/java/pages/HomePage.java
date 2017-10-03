package pages;

import org.openqa.selenium.By;

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

    By shopOurMattressButton = By.xpath("(//a[text()='Shop Our Hybrid Mattress'])[1]");
    By shopOurMonitorButton = By.xpath("(//a[text()='Shop Our Monitor'])[1]");
    By shopFoamPillowButton = By.xpath("(//a[text()='Shop Our Pillow'])[1]");
    /** Page Methods */

    public MattressesPage clickOnShopOurMattressButton() {
        reporter.info("Click on Shop Our Mattress");
        scrollToShopElement(driver().findElement(shopOurMattressButton));
        findElement(shopOurMattressButton).click();
        return MattressesPage.Instance;
    }

    public MonitorPage clickOnShopOurMonitorButton() {
        reporter.info("Click on Shop Our Monitor");
        scrollToShopElement(driver().findElement(shopOurMonitorButton));
        findElement(shopOurMonitorButton).click();
        return MonitorPage.Instance;
    }

    public FoamPillowPage clickOnShopFoamPillowButton() {
        reporter.info("Click on Shop Our Pillow");
        scrollToShopElement(driver().findElement(shopFoamPillowButton));
        findElement(shopFoamPillowButton).click();
        return FoamPillowPage.Instance;
    }

}
