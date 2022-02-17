package gofood.service;

public interface FoodService {
    void fetchInput();
    void createFoodItems();
    void generateBill();
    void displayInvoice();

    Float getBill();
}
