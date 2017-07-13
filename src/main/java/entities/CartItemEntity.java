package entities;

/**
 * Created by odiachuk on 13.07.17.
 *
 * Represents item in a Cart
 *
 */

public class CartItemEntity extends BaseEntity{
    String title;
    float price;
    String size;
    String type;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    int qty;

    public CartItemEntity(String title, float price, int qty,  String size, String type) {
        this.title = title;
        this.price = price;
        this.qty = qty;
        this.type = type;
        this.size = size;

    }

    public CartItemEntity(){};

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
