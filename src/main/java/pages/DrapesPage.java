package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class DrapesPage extends BaseProductPage{

        private static DrapesPage instance;
        public static DrapesPage Instance = (instance != null) ? instance : new DrapesPage();

    public DrapesPage(){
        pageURL = "/drapes";
    }

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

  //  By addToCartButton = By.id("product-addtocart-button");
    By selectDrapesSize = By.cssSelector("div.bed-size-select");

    /** Page Methods */

//    public DrapesPage clickAddToCart() {
//        reporter.info("Click Add to cart button");
//        clickOnElement(addToCartButton);
//        return this;
//    }

    public DrapesPage selectDrapesSize(String value) {
            reporter.info("Select Drapes size: " + value);
            findElement(selectDrapesSize).click();
            findElement(By.xpath("//div[@class='option' and contains(text(),'" + value + "')]")).click();
            if (!findElement(selectDrapesSize).getText().contains(value)){
                reporter.fail("Item was not changed to: " + value);
        }
        return this;
    }

    public DrapesPage selectDrapesColor(String color) {
        reporter.info("Select Drapes color: " + color);
        clickOnElement(By.xpath("//div[@option-label='" + color + "']"));
        return this;
    }
}
