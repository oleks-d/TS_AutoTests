package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class MattressProtectorPage extends BasePage{


        private final static String pageTitle = "";
        private static MattressProtectorPage instance;
        public static MattressProtectorPage Instance = (instance != null) ? instance : new MattressProtectorPage();

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

        /** UI Mappings */

        By addToCartButton = By.id("product-addtocart-button");


        /** Page Methods */

//    public MattressProtectorPage selectMonitorType(String monitorType) {
//        reporter.info("Select monitor type: " + monitorType);
//        findElement(By.xpath("//div[@option-label='" + monitorType + "']")).click();
//        if (!findElement(By.xpath("//div[@option-label='" + monitorType + "']")).getAttribute("class").contains("selected"))
//            reporter.fail("Item was not selected: " + monitorType);
//        return this;
//    }
//
//    public MattressProtectorPage clickAddToCart() {
//        reporter.info("Click Add to cart button");
//        clickOnElement(addToCartButton);
//        return this;
//    }
}
