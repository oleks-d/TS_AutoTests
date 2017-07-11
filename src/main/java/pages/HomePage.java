package pages;

import enums.ProductTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by odiachuk on 07.07.17.
 */
public class HomePage extends BasePage{

    private final static String pageTitle = "";
    private static HomePage instance;
    public static HomePage Instance = (instance != null) ? instance : new HomePage();

    HomePage(){
            instance = Instance;
            waitForPageToLoad();
        }

    /** UI Mappings */

    By shopOurMattressButton = By.xpath("(//a[text()='Shop Our Mattress'])[1]");
    By shopOurMonitorButton = By.xpath("(//a[text()='Shop Our Monitor'])[1]");

    By showCartButton = By.cssSelector("a.action.showcart");

    //cart
    By cartItems = By.cssSelector("div.product-item-details");
    By cartItemName = By.cssSelector("strong.product-item-name");
    By cartItemContent = By.cssSelector("div.content");
    By cartBox = By.xpath("//div[@data-role='dropdownDialog']");
    By cartCheckoutButton = By.cssSelector("button#top-cart-btn-checkout");

    /** Page Methods */

    public MattressesPage clickOnShopOurMattressButton() {
        reporter.info("Click on Shop Our Mattress");
        findElement(shopOurMattressButton).click();
        return MattressesPage.Instance;
    }

    public boolean validateMattressInCart(String mattressSize, String mattressFeel) {
        String itemName = ProductTypes.MATTRESS.toString();
        openCart();
        for (WebElement cartItem : findElements (cartItems)){
            if (cartItem.findElement(cartItemName).getText().contains(itemName)) {
                String currentContent = cartItem.findElement(cartItemContent).getText();
                if (currentContent.contains(mattressSize)
                        && currentContent.contains(mattressFeel)) {
                    reporter.pass("Current Item content: " + currentContent+ " .Expected content: " + mattressSize + " " + mattressFeel);
                    return true;
                }
                else {
                    reporter.fail("Current Item content: " + currentContent + " .Expected content: " + mattressSize + " " + mattressFeel);
                    return false;
                }
            }
        }

        reporter.fail("No Cart items were found");
        return false;
    }

    public MonitorPage clickOnShopOurMonitorButton() {
        scrollToElement(driver().findElement(shopOurMonitorButton));
        reporter.info("Click on Shop Our Monitor");
        findElement(shopOurMonitorButton).click();
        return MonitorPage.Instance;
    }

    public boolean validateMonitorInCart(String monitorType) {
        String itemName = ProductTypes.MONITOR.toString();
        openCart();
        for (WebElement cartItem : findElements (cartItems)){
            if (cartItem.findElement(cartItemName).getText().contains(itemName));
            String currentContent = cartItem.findElement(cartItemContent).getText();
            if (currentContent.contains(monitorType)) {
                reporter.pass("Current Item content: " + currentContent+ " .Expected content: " + monitorType);
                return true;
            } else {
                reporter.fail("Current Item content: " + currentContent+ " .Expected content: " + monitorType);
                return false;
            }
        }

        reporter.fail("No Cart items were found");
        return false;
    }

    public HomePage openCart(){
        reporter.info("Click on Show cart buttton");
        if (isElementPresent(cartBox)){
            findElement(showCartButton).click();
        };
        findElement(showCartButton).click();
        findElement (cartItems);
        return this;
    }

    public CheckoutPage clickOnCheckoutButton(){

        return CheckoutPage.Instance;
    }
}
