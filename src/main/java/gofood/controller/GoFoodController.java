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
    public Order setInput(@RequestBody Order order) {
        foodService.setOrder(order);
        return order;
    }

    @PostMapping("/bill")
    public String getBill(@RequestParam Integer id) {
        foodService.generateBill(id);
        return "Bill generated for order " + id;
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
