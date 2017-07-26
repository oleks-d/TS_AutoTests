package pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

/**
 * Created by odiachuk on 07.07.17.
 */
public class ComforterPage extends BaseProductPage{

        private static ComforterPage instance;
        public static ComforterPage Instance = (instance != null) ? instance : new ComforterPage();

    public ComforterPage(){
        pageURL = "/comforter";
    }

        /** Common elements **/

        public PageHeader header = PageHeader.Instance;

        /** UI Mappings */

        //By addToCartButton = By.id("product-addtocart-button");
        By selectComforterSize = By.cssSelector("div.bed-size-select");

        /** Page Methods */

        public ComforterPage selectComforterSize(String size) {
                header.closeCart();
                reporter.info("Select Comforter size: " + size);
                try {  // TODO
                    findElement(selectComforterSize).click();
                } catch(WebDriverException e){
                    header.closeCart();
                    findElement(selectComforterSize).click();
                }
                findElement(By.xpath("//div[@class='option' and contains(text(),'" + size + "')]")).click();
                if (!findElement(selectComforterSize).getText().contains(size)){
                        reporter.fail("Item was not changed to: " + size);
                }
                return this;
        }

    public ComforterPage clickAddToCart() {
        super.clickAddToCart();
        return this;
    }
}
