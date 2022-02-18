package gofood.service;

import gofood.Constants;
import gofood.model.FoodItem;
import gofood.model.Order;
import gofood.storage.Memory;

import java.io.*;
import java.util.Scanner;

import static gofood.Constants.*;

public class FoodServiceImpl implements FoodService {
    public static Integer counter = 0;
    public Memory memory;
    private Order order;
    private Float bill = 0.0f;

    public FoodServiceImpl() {
        this.order = new Order();
        this.memory = new Memory();
    }

    public FoodServiceImpl(Order order) {
        this.order = order;
        this.memory = new Memory();
    }

    @Override
    public void fetchInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Special Day? ");
        order.isSpecial = scanner.nextLine().trim().toUpperCase();
        System.out.println("Items: ");
        String itemLine = scanner.nextLine().trim().toUpperCase();
        if (itemLine != "") {
            String items[] = itemLine.split(",");
            FoodItem foodItems[] = new FoodItem[items.length];
            for (String i : items) {
                foodItems[0] = new FoodItem(i);
            }
            order.foodItems = foodItems;
        }
        System.out.println("Peak hour? ");
        order.isPeakHour = scanner.nextLine().trim().toUpperCase();
        System.out.println("Night Order? ");
        order.isNightOrder = scanner.nextLine().trim().toUpperCase();
    }

    public void setOrder(Order order) {
        order.orderID = counter++;
        for (int i = 0; i < order.foodItems.length; i++) {
            order.foodItems[i].setItemPrice(Constants.valueOf(order.foodItems[i].getItemName().toUpperCase().trim()).getVal());
        }
        this.order = order;
        this.memory.orderMap.put(order.orderID, order);

    }

    @Override
    public void generateBill(Integer id) {
        Order order = memory.orderMap.get(id);
        Float totalItemPrices = 0.0f;
        for (FoodItem item : order.foodItems) {
            totalItemPrices += (item.getItemPrice() * item.getQuantity());
        }
        bill = addGST(totalItemPrices);
        if (totalItemPrices < Constants.minimumOrder) {
            getDeliveryCharges(bill);
        }
        //writing to a file bill.txt
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("bill_" + order.orderID + ".txt"), "utf-8"))) {
            writer.write(order.toString() + "\n\n " + "Total Amount to be paid:  INR " + bill);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayInvoice() {

        System.out.println(order.toString());
        System.out.println("Your bill is " + bill);
    }

    @Override
    public Float getBill() {
        return this.bill;
    }


    void getDeliveryCharges(Float totalItemPrice) {

        boolean isNormalDelivery = true;
        if (order.isSpecial.equalsIgnoreCase("YES")) {
            isNormalDelivery = false;
            totalItemPrice += SPECIAL_DAY.getVal();
        }
        if (order.isPeakHour.equalsIgnoreCase("YES")) {
            isNormalDelivery = false;
            totalItemPrice += PEAK_HOUR.getVal();
        }
        if (order.isNightOrder.equalsIgnoreCase("YES")) {
            isNormalDelivery = false;
            totalItemPrice += NIGHT_CHARGES.getVal();
        }
        if (isNormalDelivery) {
            totalItemPrice += NORMAL_CHARGES.getVal();
        }
        bill = totalItemPrice;
    }

    Float addGST(Float totalItemPrice) {
        return totalItemPrice * (100 + GST.getVal()) / 100f;
    }

}
