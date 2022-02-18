package gofood;

import gofood.model.FoodItem;
import gofood.model.Order;
import gofood.service.FoodServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoFoodAppTest {
    GoFoodApp goFoodApp;

    @Test
    public void TestGenerateBillForBurgerAndCoke() {
        generateTestDataForBurgerAndCoke();
        goFoodApp.foodService.generateBill(0);
        assertEquals("Should be 227.5 ", 227.5f, goFoodApp.foodService.getBill(), 0f);
    }

    @Test
    public void TestGenerateBillForOnePizza() {
        generateTestDataForOnePizza();
        goFoodApp.foodService.generateBill(0);
        assertEquals("Should be 237.5 ", 237.5f, goFoodApp.foodService.getBill(), 0f);
    }

    @Test
    public void TestGenerateBillForPizzaBurgerAndCoke() {
        generateTestDataForBurgerPizzaAndCoke();
        goFoodApp.foodService.generateBill(0);
        assertEquals("Should be 577.5 ", 577.5f, goFoodApp.foodService.getBill(), 0f);
    }

    private void generateTestDataForBurgerAndCoke() {
        Order order = new Order();
        order.orderID = 0;
        order.isSpecial = "YES";
        order.isNightOrder = "YES";
        order.foodItems = new FoodItem[]{new FoodItem("burger", 100f), new FoodItem("coke", 50f)};

        FoodServiceImpl foodService = new FoodServiceImpl(order);
        foodService.setOrder(order);
        foodService.memory.orderMap.put(order.orderID, order);

        goFoodApp = new GoFoodApp();
        goFoodApp.foodService = foodService;

    }

    private void generateTestDataForBurgerPizzaAndCoke() {

        Order order = new Order();
        order.orderID = 0;
        order.isSpecial = "YES";
        order.isNightOrder = "YES";
        order.isPeakHour = "YES";
        order.foodItems = new FoodItem[]{new FoodItem("burger", 100f, 2),
                new FoodItem("coke", 50f),
                new FoodItem("pizza", 150f, 2)};

        FoodServiceImpl foodService = new FoodServiceImpl(order);
        foodService.memory.orderMap.put(order.orderID, order);
        goFoodApp = new GoFoodApp();
        goFoodApp.foodService = foodService;

    }

    private void generateTestDataForOnePizza() {
        Order order = new Order();
        order.orderID = 0;
        order.isSpecial = "YES";
        order.isPeakHour = "YES";
        order.foodItems = new FoodItem[]{
                new FoodItem("pizza", 150f, 1)};

        FoodServiceImpl foodService = new FoodServiceImpl(order);
        foodService.memory.orderMap.put(order.orderID, order);
        goFoodApp = new GoFoodApp();
        goFoodApp.foodService = foodService;

    }


}