package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class Order {
    private double sum;
    public int pr;
    private int num = 0;
    private static int c;


    public Order (double sum) {
        this.sum = sum;
        if (this.getSum() <= 10000.0) pr = 3;
        if (this.getSum() > 10000.0 & this.getSum() <= 20000.0) pr = 2;
        if (this.getSum() > 20000.0) pr = 1;
        c++;
        num+=c;
        }

    public double getSum(){
return this.sum;
    }
    public  int getNum() {
        return this.num;
    }
    public String toString () {
        return ("Num = "+ this.getNum() +"\n"+"Sum = "+ this.getSum() +"\n"+"Prior = "+ this.pr +"\n");
    }
}
