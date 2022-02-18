package gofood;

import gofood.service.FoodService;
import gofood.service.FoodServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoFoodApp {
    FoodService foodService;

    public GoFoodApp() {
        this.foodService = new FoodServiceImpl();
    }


    public static void main(String[] args) {

//        GoFoodApp goFoodApp = new GoFoodApp();
//        goFoodApp.foodService.fetchInput();
//        goFoodApp.foodService.createFoodItems();
//        goFoodApp.foodService.generateBill();
//
//        goFoodApp.foodService.displayInvoice();

//        Order order = new Order();
//        ArrayList<FoodItem> list = new ArrayList();
//        list.add(new FoodItem("pizza", 0.0f, 1));
//        list.add(new FoodItem("coke", 0.0f, 1));
//        String json = new Gson().toJson(list);
//        System.out.println(json);
//        order.foodItems = list;

        SpringApplication.run(GoFoodApp.class, args);

    }


}
