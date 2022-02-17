package gofood.controller;

import gofood.service.FoodServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class GoFoodController {
    public FoodServiceImpl foodService;

    @GetMapping("/invoice")
    public String getInvoice() {
        try {
            return readFileAsString("bill.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
}
