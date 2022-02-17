package gofood.model;

public class FoodItem {
    String itemName;
    Float itemPrice;
    Integer quantity;

    public FoodItem(String itemName, Float itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = 1;
    }

    public FoodItem(String itemName, Float itemPrice, Integer quantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }

    public Integer getQuantity() {
        return quantity;
    }
}
