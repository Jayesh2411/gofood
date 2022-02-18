package gofood.model;

import gofood.Constants;
import org.springframework.stereotype.Component;

@Component
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

    public FoodItem(String itemName, Integer quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemPrice = Constants.valueOf(itemName.toUpperCase().trim()).getVal();
    }

    public FoodItem(String itemName) {
        this.itemName = itemName;
    }

    public FoodItem() {
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
