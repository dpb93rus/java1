package ru.progwards.java1.lessons.files;

public class OrderItem {

    public String googsName;

    public int count;

    public double price;

    @Override
    public String toString() {
        return "OI{" +
                "gName='" + googsName + '\'' +
                ", c=" + count +
                ", pr=" + price +
                '}';
    }

    public OrderItem (String googsName, int count, double price) {
        this.count = count;
        this.googsName = googsName;
        this.price = price;
    }
}
