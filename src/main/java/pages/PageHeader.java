package pages;

import enums.ProductTypes;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by odiachuk on 12.07.17.
 */
public class PageHeader extends BasePage {

    private static PageHeader instance;
    public static PageHeader Instance = (instance != null) ? instance : new PageHeader();

    PageHeader(){
        instance = Instance;
        waitForPageToLoad();
    }

    //top menu
    By topMenuItem_Shop = By.xpath("//ul[@role='menu']//a[@role='menuitem']//span[text()='Shop']");
    By topMenuItem_Sleep = By.xpath("//ul[@role='menu']//a[@role='menuitem']//span[text()='Sleep']");


    By topMenuItem_SignIn = By.xpath("//ul[@class='header links']//a[contains(text(),'Sign In')]");

    //cart
    By showCartButton = By.cssSelector("a.action.showcart");

    //cart
    By cartItems = By.cssSelector("div.product-item-details");
    By cartItemName = By.cssSelector("strong.product-item-name");
    By cartItemContent = By.cssSelector("div.content");
    By cartBox = By.xpath("//div[@data-role='dropdownDialog']");
    By cartCheckoutButton = By.cssSelector("button#top-cart-btn-checkout");

    /** Menu Methods */

    public ShopPage clickShopMenuItem(){
        reporter.info("Click on SHOP menu item");
        clickOnElement(topMenuItem_Shop);
        return ShopPage.Instance;
    }

    public LoginPage clickSignInMenuItem(){
        reporter.info("Click on SIGN IN menu item");
        clickOnElement(topMenuItem_SignIn);
        return LoginPage.Instance;
    }


    /** Cart Methods */

    public PageHeader openCart(){
        reporter.info("Click on Show cart buttton");
        if (isElementPresent(cartBox)){
            findElement(showCartButton).click();
        };
        findElement(showCartButton).click();
        findElement (cartItems);
        return this;
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


    public boolean validateMattressInCart(String mattressSize, String mattressFeel) {
        String itemName = ProductTypes.MATTRESS.toString();
        openCart();
        for (WebElement cartItem : findElements(cartItems)) {
            if (cartItem.findElement(cartItemName).getText().contains(itemName)) {
                String currentContent = cartItem.findElement(cartItemContent).getText();
                if (currentContent.contains(mattressSize)
                        && currentContent.contains(mattressFeel)) {
                    reporter.pass("Current Item content: " + currentContent + " .Expected content: " + mattressSize + " " + mattressFeel);
                    return true;
                } else {
                    reporter.fail("Current Item content: " + currentContent + " .Expected content: " + mattressSize + " " + mattressFeel);
                    return false;
                }
            }
        }
        reporter.fail("No Cart items were found");
        return false;
    }

    public boolean validateItemContentByTitle( String title, String... expectedContent) {
        boolean result = true;
        List<WebElement> currentCartItems = new ArrayList<WebElement>();
        String itemName = title;

        openCart();
        for (String expectedField : expectedContent){
            currentCartItems = findElements(cartItems);
            for (WebElement cartItem : currentCartItems ) {
                if (cartItem.findElement(cartItemName).getText().contains(itemName)) {
                    String currentContent = cartItem.findElement(cartItemContent).getText();
                    if (currentContent.contains(expectedField)) {
                        reporter.pass("Current Item content: " + currentContent + ". Expected content: " + expectedField);
                        result = result && true;
                    } else {
                        reporter.fail("Current Item content: " + currentContent + ". Expected content: " + expectedField);
                        result =  result && false;
                    }
                }
            }
        }
        if (currentCartItems.size() == 0) {
            reporter.fail("No Cart items were found");
            return false;
        }

        return result;
    }




}
