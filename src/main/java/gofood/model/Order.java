package gofood.model;

import java.util.Arrays;

public class Order {


    public String isPeakHour = "No";
    public String isNightOrder = "No";
    public String isSpecial = "NO";
    public String[] items;

    @Override
    public String toString() {
        return "Invoice \n \n "+"Order{" +
                "isPeakHour='" + isPeakHour + '\'' +
                ", isNightOrder='" + isNightOrder + '\'' +
                ", isSpecial='" + isSpecial + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
