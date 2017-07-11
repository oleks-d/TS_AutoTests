package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class ComforterPage extends BasePage{


        private final static String pageTitle = "";
        private static ComforterPage instance;
        public static ComforterPage Instance = (instance != null) ? instance : new ComforterPage();

        ComforterPage(){
            instance = Instance;
            waitForPageToLoad();
        }

        /** UI Mappings */

        By addToCartButton = By.id("product-addtocart-button");


        /** Page Methods */

    public ComforterPage selectMonitorType(String monitorType) {
        reporter.info("Select monitor type: " + monitorType);
        findElement(By.xpath("//div[@option-label='" + monitorType + "']")).click();
        if (!findElement(By.xpath("//div[@option-label='" + monitorType + "']")).getAttribute("class").contains("selected"))
            reporter.fail("Item was not selected: " + monitorType);
        return this;
    }

    public ComforterPage clickAddToCart() {
        reporter.info("Click Add to cart button");
        clickOnElement(addToCartButton);
        return this;
    }
}
