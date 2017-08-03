package pages;

import org.openqa.selenium.By;

/**
 * Created by odiachuk on 07.07.17.
 */
public class BaseProductPage extends BasePage{

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

        /** UI Mappings */
        By selectMattressSize = By.cssSelector("div.bed-size-select");
        By addToCartButton = By.id("product-addtocart-button");
        By updateItemButton = By.id("product-updatecart-button");

        /** Page Methods */

//    public BaseProductPage selectSize(String value){
//        reporter.info("Select size: " + value);
//        findElement(selectMattressSize).click();
//        findElement(By.xpath("//div[@class='option' and contains(text(),'" + value + "')]")).click();
//        if (!findElement(selectMattressSize).getText().contains(value)){
//            reporter.fail("Item was not changed to: " + value);
//        }
//        return this;
//    }
//
//    public BaseProductPage selecType(String type) {
//        reporter.info("Select type: " + type);
//        findElement(By.xpath("//div[@option-label='" + type + "']")).click();
//        if (!findElement(By.xpath("//div[@option-label='" + type + "']")).getAttribute("class").contains("selected"))
//            reporter.fail("Item was not selected: " + type);
//        return this;
//    }

    public BaseProductPage clickAddToCart() {
        reporter.info("Add to Cart button");
        header.closeCart();
        clickOnElement(addToCartButton);
        if (header.waitUntilItemWillBeDropedToCart() == false) {
            driver().navigate().refresh();
            waitForPageToLoad();
            if (header.waitUntilItemWillBeDropedToCart() == false) {
                reporter.info("Second attempt to click Add to Cart");
                clickOnElement(addToCartButton);
            }
        };
        return this;
    }

    public BaseProductPage clickUpdateCart() {
        reporter.info("Update cart item button");
        header.closeCart();
        clickOnElement(updateItemButton);
        return this;
    }
}