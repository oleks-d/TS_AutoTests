package pages;

import entities.ItemEntity;
import entities.UserEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by odiachuk on 07.07.17.
 */
public class ViewCartPage extends BasePage {

    private static ViewCartPage instance;
    public static ViewCartPage Instance = (instance != null) ? instance : new ViewCartPage();

    public ViewCartPage(){
        pageURL = "/checkout/cart/";
    }

    /** Common elements **/

    public PageHeader header = PageHeader.Instance;

    /**
     * UI Mappings
     */


    //order list

    By orderItems = By.cssSelector("tr.item-info");
    By orderItemName = By.cssSelector("strong.product-item-name");
    By orderItemQty = By.cssSelector("input");
    By orderItemPrice = By.cssSelector("span.price");
    By orderItemDetails= By.cssSelector("dd");

    /** Page Methods */


    public boolean itemDisplayedOnCheckoutPage(ItemEntity item) {
        ArrayList<ItemEntity> items = getAllCheckoutPageItems();
        return items.stream()
                .filter(cur -> item.getTitle().equals(cur.getTitle()))
                .filter(cur -> item.getQty() == cur.getQty())
                .filter(cur -> item.getPrice() == cur.getPrice())
                .filter(cur -> cur.getType().contains(item.getType()))
                .filter(cur -> cur.getSize().contains(item.getSize())).count() > 0;
    }

    private ArrayList<ItemEntity> getAllCheckoutPageItems() {
        ArrayList<ItemEntity> result = new ArrayList<>();
        reporter.info("Getting order items");
        findElement(orderItems); // wait for order
        List<WebElement> itemsList = findElements(orderItems);
        for (WebElement orderItem : itemsList ) {
            ItemEntity currentItem = new ItemEntity();

            currentItem.setTitle(orderItem.findElement(orderItemName).getText());

            currentItem.setQty(Integer.valueOf(orderItem.findElement(orderItemQty).getText()));

            currentItem.setPrice(Float.valueOf(orderItem.findElement(orderItemPrice).getText().replace("$","")));
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
            reporter.info("No items were found on Checkout page");
            //Assert.fail("No items were found on Checkout page");
        }

        return result;
    }
}
