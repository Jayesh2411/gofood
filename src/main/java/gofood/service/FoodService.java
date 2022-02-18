package gofood.service;

public interface FoodService {
    void fetchInput();

    void generateBill(Integer id);

    void displayInvoice();

    Float getBill();
}
