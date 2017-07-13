package pages;

import enums.ProductTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by odiachuk on 07.07.17.
 */
public class ShopPage extends BasePage{

    private final static String pageTitle = "";
    private static ShopPage instance;
    public static ShopPage Instance = (instance != null) ? instance : new ShopPage();

    /** UI Mappings */

    By shopOurMattressButton = By.xpath("(//a[text()='Shop Our Mattress'])[1]");
    By shopOurFoamPillowButton = By.xpath("(//a[text()='SHOP OUR PILLOW'])[1]");
    By shopOurPlushPillowButton = By.xpath("(//a[text()='SHOP OUR PILLOW'])[2]");

    By shopOurTrackerButton = By.xpath("(//a[text()='SHOP OUR TRACKER'])[1]");
    By shopOurSheetsButton = By.xpath("(//a[text()='SHOP OUR SHEETS'])[1]");
    By shopOurComforterButton = By.xpath("(//a[text()='SHOP OUR COMFORTER'])[1]");
    By shopOurCoverButton = By.xpath("(//a[text()='SHOP OUR COVER'])[1]");
    By shopOurDrapesButton = By.xpath("(//a[text()='SHOP OUR DRAPES'])[1]");

    /** Page Methods */

    public MattressesPage clickOnShopOurMattressButton() {
        reporter.info("Click on Shop Our Mattress");
        findElement(shopOurMattressButton).click();
        return MattressesPage.Instance;
    }

    public FoamPillowPage clickOnShopOurFoamPillowButton() {
        reporter.info("Click on Shop Our Pillow (Foam)");
        findElement(shopOurFoamPillowButton).click();
        return FoamPillowPage.Instance;
    }

    public PlushPillowPage clickOnShopOurPlushPillowButton() {
        reporter.info("Click on Shop Our Pillow (Plush)");
        findElement(shopOurPlushPillowButton).click();
        return PlushPillowPage.Instance;
    }

    public MonitorPage clickOnShopOurMonitorButton() {
        reporter.info("Click on Shop Our Monitor");
        findElement(shopOurTrackerButton).click();
        return MonitorPage.Instance;
    }

    public SheetsetPage clickOnShopOurSheetsButton() {
        reporter.info("Click on Shop Our Sheets");
        findElement(shopOurSheetsButton).click();
        return SheetsetPage.Instance;
    }

    public ComforterPage clickOnShopOurComforterButton() {
        reporter.info("Click on Shop Our Comforter");
        findElement(shopOurComforterButton).click();
        return ComforterPage.Instance;
    }

    public MattressProtectorPage clickOnShopOurCoverButton() {
        reporter.info("Click on Shop Our Cover");
        findElement(shopOurCoverButton).click();
        return MattressProtectorPage.Instance;
    }

    public DrapesPage clickOnShopOurDrapesButton() {
        reporter.info("Click on Shop Our Mattress");
        findElement(shopOurDrapesButton).click();
        return DrapesPage.Instance;
    }

}
