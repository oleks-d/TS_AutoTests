package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class DrapesPage extends BasePage{


        private final static String pageTitle = "";
        private static DrapesPage instance;
        public static DrapesPage Instance = (instance != null) ? instance : new DrapesPage();

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

        DrapesPage(){
            instance = Instance;
            waitForPageToLoad();
            URL = "/drapes";
        }

        /** UI Mappings */

        By addToCartButton = By.id("product-addtocart-button");


        /** Page Methods */

//    public DrapesPage selectMonitorType(String monitorType) {
//        reporter.info("Select monitor type: " + monitorType);
//        findElement(By.xpath("//div[@option-label='" + monitorType + "']")).click();
//        if (!findElement(By.xpath("//div[@option-label='" + monitorType + "']")).getAttribute("class").contains("selected"))
//            reporter.fail("Item was not selected: " + monitorType);
//        return this;
//    }
//
//    public DrapesPage clickAddToCart() {
//        reporter.info("Click Add to cart button");
//        clickOnElement(addToCartButton);
//        return this;
//    }
}
