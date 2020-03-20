package ru.progwards.java1.lessons.queues;

public class Order {
    private double sum;
    private int num;
    public Order (double sum) {
        int c = 0;
        c++;
        this.num = c;
        this.sum = sum;
    }
    public double getSum(){
return this.sum;
    }
    public  int getNum() {
        return this.num;
    }
}
