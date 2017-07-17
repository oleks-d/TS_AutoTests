package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class SheetsetPage extends BasePage{

        private static SheetsetPage instance;
        public static SheetsetPage Instance = (instance != null) ? instance : new SheetsetPage();

    public SheetsetPage(){
        pageURL = "/sheets";
    }

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */
    By addToCartButton = By.id("product-addtocart-button");
    By selectSheetsetSize = By.cssSelector("div.bed-size-select");

    /** Page Methods */

    public SheetsetPage selectSheetsetSize(String size) {
        reporter.info("Select Sheetset size: " + size);
        findElement(selectSheetsetSize).click();
        findElement(By.xpath("//div[@class='option' and contains(text(),'" + size + "')]")).click();
        if (!findElement(selectSheetsetSize).getText().contains(size)){
            reporter.fail("Item was not changed to: " + size);
        }
        return this;
    }

    public SheetsetPage clickAddToCart() {
        reporter.info("Click Add to cart button");
        clickOnElement(addToCartButton);
        return this;
    }
}
