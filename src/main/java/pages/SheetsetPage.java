package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class SheetsetPage extends BasePage{


        private final static String pageTitle = "";
        private static SheetsetPage instance;
        public static SheetsetPage Instance = (instance != null) ? instance : new SheetsetPage();

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

        SheetsetPage(){
            instance = Instance;
            waitForPageToLoad();
        }

        /** UI Mappings */

        By addToCartButton = By.id("product-addtocart-button");


        /** Page Methods */

//    public SheetsetPage selectMonitorType(String monitorType) {
//        reporter.info("Select monitor type: " + monitorType);
//        findElement(By.xpath("//div[@option-label='" + monitorType + "']")).click();
//        if (!findElement(By.xpath("//div[@option-label='" + monitorType + "']")).getAttribute("class").contains("selected"))
//            reporter.fail("Item was not selected: " + monitorType);
//        return this;
//    }
//
//    public SheetsetPage clickAddToCart() {
//        reporter.info("Click Add to cart button");
//        clickOnElement(addToCartButton);
//        return this;
//    }
}
