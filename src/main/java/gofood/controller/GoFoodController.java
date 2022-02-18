package gofood.controller;

import gofood.model.Order;
import gofood.service.FoodServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class GoFoodController {

    public FoodServiceImpl foodService = new FoodServiceImpl();

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }


    @PostMapping("/input")
    public String setInput(@RequestBody Order order) {
        foodService.setOrder(order);
        return "Your Order Number " + order.orderID + " Received!";
    }

    @PostMapping("/bill")
    public String getBill() {
        foodService.generateBill();
        return "Bill Generated";
    }

    @PostMapping("/invoice")
    public String getInvoice(@RequestParam Integer id) {
        try {
            return readFileAsString("bill_" + id + ".txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
