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
        goFoodApp.foodService.generateBill();
        assertEquals("Should be 227.5 ", 227.5f, goFoodApp.foodService.getBill(), 0f);
    }

    @Test
    public void TestGenerateBillForOnePizza() {
        generateTestDataForOnePizza();
        goFoodApp.foodService.generateBill();
        assertEquals("Should be 237.5 ", 237.5f, goFoodApp.foodService.getBill(), 0f);
    }

    @Test
    public void TestGenerateBillForPizzaBurgerAndCoke() {
        generateTestDataForBurgerPizzaAndCoke();
        goFoodApp.foodService.generateBill();
        assertEquals("Should be 577.5 ", 577.5f, goFoodApp.foodService.getBill(), 0f);
    }

    private void generateTestDataForBurgerAndCoke() {
        Order order = new Order();
        order.isSpecial = "YES";
        order.isNightOrder = "YES";

        FoodServiceImpl foodService = new FoodServiceImpl(order);
        foodService.memory.foodItems.add(new FoodItem("burger", 100f));
        foodService.memory.foodItems.add(new FoodItem("coke", 50f));

        goFoodApp = new GoFoodApp();
        goFoodApp.foodService = foodService;

    }

    private void generateTestDataForBurgerPizzaAndCoke() {
        Order order = new Order();
        order.isSpecial = "YES";
        order.isNightOrder = "YES";

        FoodServiceImpl foodService = new FoodServiceImpl(order);
        foodService.memory.foodItems.add(new FoodItem("burger", 100f, 2));
        foodService.memory.foodItems.add(new FoodItem("pizza", 150f, 2));
        foodService.memory.foodItems.add(new FoodItem("coke", 50f));

        goFoodApp = new GoFoodApp();
        goFoodApp.foodService = foodService;

    }

    private void generateTestDataForOnePizza() {
        Order order = new Order();
        order.isSpecial = "YES";
        order.isPeakHour = "YES";

        FoodServiceImpl foodService = new FoodServiceImpl(order);
        foodService.memory.foodItems.add(new FoodItem("pizza", 150f, 1));

        goFoodApp = new GoFoodApp();
        goFoodApp.foodService = foodService;

    }


}