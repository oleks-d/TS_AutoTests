package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class FoamPillowPage extends BasePage{


        private final static String pageTitle = "";
        private static FoamPillowPage instance;
        public static FoamPillowPage Instance = (instance != null) ? instance : new FoamPillowPage();

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

        /** UI Mappings */

        By addToCartButton = By.id("product-addtocart-button");


        /** Page Methods */

//    public FoamPillowPage selectMonitorType(String monitorType) {
//        reporter.info("Select monitor type: " + monitorType);
//        findElement(By.xpath("//div[@option-label='" + monitorType + "']")).click();
//        if (!findElement(By.xpath("//div[@option-label='" + monitorType + "']")).getAttribute("class").contains("selected"))
//            reporter.fail("Item was not selected: " + monitorType);
//        return this;
//    }
//
//    public FoamPillowPage clickAddToCart() {
//        reporter.info("Click Add to cart button");
//        clickOnElement(addToCartButton);
//        return this;
//    }
}
