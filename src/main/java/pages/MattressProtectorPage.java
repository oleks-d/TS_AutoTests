package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class MattressProtectorPage extends BaseProductPage{


        private final static String pageTitle = "";
        private static MattressProtectorPage instance;
        public static MattressProtectorPage Instance = (instance != null) ? instance : new MattressProtectorPage();

    public MattressProtectorPage(){
        pageURL = "/mattress-protector";
    }

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

 //   By addToCartButton = By.id("product-addtocart-button");
    By selectProtectorSize = By.cssSelector("div.bed-size-select");

        /** Page Methods */

        public MattressProtectorPage selectProtectorSize(String size) {
            reporter.info("Select Protector size: " + size);
            header.closeCart();
            findElement(selectProtectorSize).click();
            findElement(By.xpath("//div[@class='option' and contains(text(),'" + size + "')]")).click();
            if (!findElement(selectProtectorSize).getText().contains(size)){
                reporter.fail("Item was not changed to: " + size);
            }
            return this;
        }

    public MattressProtectorPage clickAddToCart() {
        super.clickAddToCart();
        return this;
    }

}
