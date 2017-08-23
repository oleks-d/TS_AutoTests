package pages;

import entities.ItemEntity;
import entities.UserEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Tools;

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
    By orderItemEditButton = By.cssSelector("a.action.action-edit");
    By orderItemDeleteButton = By.cssSelector("a.action.action-delete");
    By backToShopLink = By.xpath("//A[@class='back-to-shop'][text()='Back to Shop']");

    By orderIncreaseQuantityItemButton = By.xpath("//button[@name='update_cart_action' and @title='+']");
    By orderDecreaseQuantityItemButton = By.xpath("//button[@name='update_cart_action' and @title='-']");

    /** Page Methods */

    public boolean itemDisplayedOnViewCartPage(ItemEntity item) {
        ArrayList<ItemEntity> items = getAllViewCartPageItems();
        return items.stream()
                .filter(cur -> item.getTitle() == null || item.getTitle().equals(cur.getTitle()))
                .filter(cur -> item.getQty() == 0 || item.getQty() == cur.getQty())
                .filter(cur -> item.getPrice() == 0 ||item.getPrice() == cur.getPrice())
                .filter(cur -> item.getType() == null || cur.getType().contains(item.getType()))
                .filter(cur -> item.getSize() == null || cur.getSize().contains(item.getSize())).count() > 0;
    }

    public boolean itemDisplayedOnViewCartPage(String itemName) {
        ArrayList<ItemEntity> items = getAllViewCartPageItems();
        return items.stream()
                .filter(cur -> itemName.equals(cur.getTitle()))
        .count() > 0;
    }

    public boolean itemDisplayedOnViewCartPage(String itemName, int qty) {
        ArrayList<ItemEntity> items = getAllViewCartPageItems();
        return items.stream()
                .filter(cur -> itemName.equals(cur.getTitle()))
                .filter(cur -> qty == cur.getQty())
                .count() > 0;
    }

    private ArrayList<ItemEntity> getAllViewCartPageItems() {
        ArrayList<ItemEntity> result = new ArrayList<>();
        reporter.info("Getting order items");
        findElementIgnoreException(orderItems); // wait for order
        List<WebElement> itemsList = findElementsIgnoreException(orderItems);
        for (WebElement orderItem : itemsList ) {
            ItemEntity currentItem = new ItemEntity();

            currentItem.setTitle(orderItem.findElement(orderItemName).getText());

            currentItem.setQty(Integer.valueOf(orderItem.findElement(orderItemQty).getAttribute("value")));

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
            reporter.info("No items were found on Checkout page");
            //Assert.fail("No items were found on Checkout page");
        }

        return result;
    }

    // click on product name on product cart
    public void clickOnProduct(String itemName) {
        reporter.info("Open item from View cart page: " + itemName );
        clickOnElement(By.xpath("(//a[text()='" + itemName + "'])[2]"));
    }

    //click on edit button for item in View Cart
    public void clickOnEditProduct(String itemName) {
        reporter.info("Edit item from View cart page: " + itemName );
        findElement(orderItems); // wait for order
        List<WebElement> itemsList = findElements(orderItems);
        for (WebElement orderItem : itemsList ) {
            if ( orderItem.findElement(orderItemName).getText().equals(itemName)) {
                orderItem.findElement(orderItemEditButton).click();
                return;
            }
        }
    }

    //click on delete button for item in View Cart
    public void clickOnDeleteProduct(String itemName) {
        reporter.info("Delete item from View cart page: " + itemName );
        findElement(orderItems); // wait for order
        List<WebElement> itemsList = findElements(orderItems);
        for (WebElement orderItem : itemsList ) {
            if ( orderItem.findElement(orderItemName).getText().equals(itemName)) {
                orderItem.findElement(orderItemDeleteButton).click();
                return;
            }
        }
    }


    public void addQuantity(String itemName) {
        reporter.info("Increase number of items on View cart page: " + itemName );
        findElement(orderItems); // wait for order
        List<WebElement> itemsList = findElements(orderItems);
        for (WebElement orderItem : itemsList ) {
            if ( orderItem.findElement(orderItemName).getText().equals(itemName)) {
                orderItem.findElement(orderIncreaseQuantityItemButton).click();
                return;
            }
        }
    }

    public void subQuantity(String itemName) {
        reporter.info("Decrease number of items on View cart page: " + itemName );
        findElement(orderItems); // wait for order
        List<WebElement> itemsList = findElements(orderItems);
        for (WebElement orderItem : itemsList ) {
            if ( orderItem.findElement(orderItemName).getText().equals(itemName)) {
                orderItem.findElement(orderDecreaseQuantityItemButton).click();
                return;
            }
        }
    }


    public void clickOnBackToShop() {
        reporter.info("Click on back to shop link");
        findElement(backToShopLink).click();
    }
}
