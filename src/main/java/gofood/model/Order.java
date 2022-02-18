package gofood.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class Order {

    public Integer orderID;
    public String isPeakHour = "No";
    public String isNightOrder = "No";
    public String isSpecial = "NO";

    @Autowired
    public FoodItem[] foodItems;


    public Order() {
    }

    public Order(Integer orderID, String isPeakHour, String isNightOrder, String isSpecial, FoodItem[] foodItems) {
        this.orderID = orderID;
        this.isPeakHour = isPeakHour;
        this.isNightOrder = isNightOrder;
        this.isSpecial = isSpecial;
        this.foodItems = foodItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", isPeakHour='" + isPeakHour + '\'' +
                ", isNightOrder='" + isNightOrder + '\'' +
                ", isSpecial='" + isSpecial + '\'' +
                ", foodItems=" + Arrays.toString(foodItems) +
                '}';
    }
}
