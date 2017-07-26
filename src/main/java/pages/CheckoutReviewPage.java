package pages;

import entities.ItemEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by odiachuk on 07.07.17.
 */
public class CheckoutReviewPage extends BasePage{

    private static CheckoutReviewPage instance;
    public static CheckoutReviewPage Instance = (instance != null) ? instance : new CheckoutReviewPage();

    public CheckoutReviewPage(){
        pageURL = "/";
    }

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /** UI Mappings */

    By paymentMethodTitle = By.xpath("//div[@class='step-title' and contains(text(),'Payment Method')]");

    //order list

    By orderItems = By.cssSelector("div.block.items-in-cart ol.minicart-items li.product-item");
    By orderItemName = By.cssSelector("strong.product-item-name");
    By orderItemQty = By.cssSelector("div.details-qty span.value");
    By orderItemPrice = By.cssSelector("span.cart-price");
    By orderItemDetails= By.cssSelector("dl.item-options span");

    By totalPrice = By.cssSelector("tr.grand.totals span.price");

    /** Page Methods */

    public boolean isPaymentMethodTitleDisplayed(){
        reporter.info("Check Payment method title exists");
        return isElementPresentAndDisplay(paymentMethodTitle);
    }

    public boolean itemWasFoundInOrder(ItemEntity item) {
        ArrayList<ItemEntity> items = getAllOrderItems();
        reporter.info("Expected item: " + item.toString());
        return items.stream()
                .filter(cur -> item.getTitle().equals(cur.getTitle()))
                .filter(cur -> item.getQty() == cur.getQty())
                .filter(cur -> item.getPrice() == cur.getPrice())
                .filter(cur -> cur.getType().contains(item.getType()))
                .filter(cur -> cur.getSize().contains(item.getSize())).count() > 0;
    }

    private ArrayList<ItemEntity> getAllOrderItems() {
        ArrayList<ItemEntity> result = new ArrayList<>();
        reporter.info("Getting order items");
        findElementIgnoreException(orderItems); //wait for items
        List<WebElement> itemsList = findElementsIgnoreException(orderItems);
        for (WebElement orderItem : itemsList ) {
            ItemEntity currentItem = new ItemEntity();

            currentItem.setTitle(orderItem.findElement(orderItemName).getText());
            currentItem.setQty(Integer.valueOf(orderItem.findElement(orderItemQty).getText()));
            currentItem.setPrice(Tools.convertStringPriceToFloat(orderItem.findElement(orderItemPrice).getText()));
            currentItem.setSize("");
            currentItem.setType("");

            List<WebElement> details = orderItem.findElements(orderItemDetails);

            for(WebElement elem : details){
                String value = elem.getText();
                if (value.contains("(") && value.contains(")"))
                    currentItem.setSize(value);
                else
                    currentItem.setType(value);
            }

            reporter.info("Order item: " + currentItem.toString());
            result.add(currentItem);

        }
        if (itemsList.size() == 0) {
            reporter.info("No Order items were found");
            ///Assert.fail("No Order items were found");
        }

        return result;
    }

    public float getTotalPrice(){
        float result;
        result = Tools.convertStringPriceToFloat(findElement(totalPrice).getText());
        reporter.info("Total price: " + result);
        return result;
    }
}
