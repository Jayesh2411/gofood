package gofood.service;

import gofood.Constants;
import gofood.storage.Memory;
import gofood.model.FoodItem;
import gofood.model.Order;

import java.io.*;
import java.util.Scanner;

import static gofood.Constants.*;

public class FoodServiceImpl implements FoodService {

    public Memory memory;
    private Order order;
    private Float bill = 0.0f;

    void initMemory() {
        this.memory = new Memory();
    }

    public FoodServiceImpl() {
        this.order = new Order();
        this.initMemory();
    }

    public FoodServiceImpl(Order order) {
        this.initMemory();
        this.order = order;
    }

    @Override
    public void fetchInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Special Day? ");
        order.isSpecial = scanner.nextLine().trim().toUpperCase();
        System.out.println("Items: ");
        order.items = scanner.nextLine().trim().toUpperCase().split(",");
        System.out.println("Peak hour? ");
        order.isPeakHour = scanner.nextLine().trim().toUpperCase();
        System.out.println("Night Order? ");
        order.isNightOrder = scanner.nextLine().trim().toUpperCase();
    }

    @Override
    public void createFoodItems() {
        for (String item : order.items) {
            memory.foodItems.add(new FoodItem(item, memory.getFoodItemPriceMap().get(Constants.valueOf(item.trim()))));
        }
    }

    @Override
    public void generateBill() {
        Float totalItemPrices = 0.0f;
        for (FoodItem item : memory.foodItems) {
            totalItemPrices += (item.getItemPrice() * item.getQuantity());
        }
        bill = addGST(totalItemPrices);
        if (totalItemPrices < Constants.minimumOrder) {
            getDeliveryCharges(bill);
        }
    }

    @Override
    public void displayInvoice() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("bill.txt"), "utf-8"))) {
            writer.write(order.toString()+"\n\n "+"Total Amount to be paid  "+bill);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(order.toString());
        System.out.println("Your bill is " + bill);
    }

    @Override
    public Float getBill() {
        return this.bill;
    }


    void getDeliveryCharges(Float totalItemPrice) {

        boolean isNormalDelivery = true;
        if (order.isSpecial.equalsIgnoreCase("yes")) {
            isNormalDelivery = false;
            totalItemPrice += memory.getDeliveryChargesMap().get(SPECIAL_DAY);
        }
        if (order.isPeakHour.equalsIgnoreCase("yes")) {
            isNormalDelivery = false;
            totalItemPrice += memory.getDeliveryChargesMap().get(PEAK_HOUR);
        }
        if (order.isNightOrder.equalsIgnoreCase("yes")) {
            isNormalDelivery = false;
            totalItemPrice += memory.getDeliveryChargesMap().get(NIGHT_CHARGES);
        }
        if (isNormalDelivery) {
            totalItemPrice += memory.getDeliveryChargesMap().get(NORMAL_CHARGES);
        }
        bill = totalItemPrice;
    }

    Float addGST(Float totalItemPrice) {
        return totalItemPrice * (100 + memory.getGst()) / 100f;
    }

}
