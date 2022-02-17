package gofood.storage;

import gofood.Constants;
import gofood.model.FoodItem;

import java.util.ArrayList;
import java.util.HashMap;

import static gofood.Constants.*;

public class Memory {
    private final Float gst = 5.0f;
    public ArrayList<FoodItem> foodItems = new ArrayList<>();
    public HashMap<Constants, Float> foodItemPriceMap = new HashMap<>();
    public HashMap<Constants, Float> deliveryChargesMap = new HashMap<>();

    public Memory() {
        foodItemPriceMap.put(PIZZA, 150.0f);
        foodItemPriceMap.put(BURGER, 100.0f);
        foodItemPriceMap.put(COKE, 50.0f);

        deliveryChargesMap.put(PEAK_HOUR, 30f);
        deliveryChargesMap.put(SPECIAL_DAY, 50f);
        deliveryChargesMap.put(NIGHT_CHARGES, 20f);
        deliveryChargesMap.put(NORMAL_CHARGES, 20f);
    }

    public HashMap<Constants, Float> getFoodItemPriceMap() {
        return foodItemPriceMap;
    }

    public HashMap<Constants, Float> getDeliveryChargesMap() {
        return deliveryChargesMap;
    }

    public Float getGst() {
        return this.gst;

    }
}
