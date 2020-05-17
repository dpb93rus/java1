package ru.progwards.java2.lessons.recursion;

import java.time.Instant;

public class Goods {
    String name;
    String number;
    int available;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' + "\n" +
                ", number='" + number + '\'' + "\n" +
                ", available=" + available + "\n" +
                ", price=" + price + "\n" +
                ", expired=" + expired +
                '}' + "\n" + "\n" ;
    }

    double price;

    public Goods(String name, String number, int available, double price, Instant expired) {
        this.name = name;
        this.number = number;
        this.available = available;
        this.price = price;
        this.expired = expired;
    }

    Instant expired;
}
