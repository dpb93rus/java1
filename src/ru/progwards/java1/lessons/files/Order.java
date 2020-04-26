package ru.progwards.java1.lessons.files;

import java.time.LocalDateTime;
import java.util.List;

public class Order implements Comparable <Order> {

    public String shopId;

    public String orderId;

    public String customerId;

    public LocalDateTime datetime;

    public List<OrderItem> items;

    public double sum;

    @Override
    public String toString() {
        return "\n Order{" +
                "shId='" + shopId + '\'' +
                ", orId='" + orderId + '\'' +
                ", cusId='" + customerId + '\'' +
                ", date=" + datetime +
                ", \n items=" + items +
                ", sum=" + sum +
                "}\n";
    }

    @Override
    public int compareTo(Order o) {
        if (this.datetime.isAfter((o.datetime))) return 1;
        if (this.datetime.isBefore((o.datetime))) return -1;
        return 0;
    }
}

