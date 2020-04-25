package ru.progwards.java1.lessons.files;

public class OrderItem {

    public String goodsName;

    public int count;

    public double price;

    public OrderItem (String goodsName, int count, double price) {
        this.count = count;
        this.goodsName = goodsName;
        this.price = price;
    }
}
