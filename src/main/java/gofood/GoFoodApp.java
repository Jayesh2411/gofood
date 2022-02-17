package gofood;

import gofood.service.FoodService;
import gofood.service.FoodServiceImpl;

public class GoFoodApp {
    FoodService foodService;

    public GoFoodApp() {
        this.foodService = new FoodServiceImpl();
    }

    public static void main(String[] args) {

        GoFoodApp goFoodApp = new GoFoodApp();
        goFoodApp.foodService.fetchInput();
        goFoodApp.foodService.createFoodItems();
        goFoodApp.foodService.generateBill();

        goFoodApp.foodService.displayInvoice();

    }


}
