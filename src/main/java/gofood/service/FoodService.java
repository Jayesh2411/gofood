package gofood.service;

public interface FoodService {
    void fetchInput();

    void generateBill();

    void displayInvoice();

    Float getBill();
}
