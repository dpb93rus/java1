package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
    Comparator<Order> c = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            if (o1.pr == o2.pr) {
                if (o1.getNum() > o2.getNum()) return 1;
                if (o1.getNum() < o2.getNum()) return -1;
            }
            if (o1.pr > o2.pr) return 1;
            if (o1.pr < o2.pr) return -1;
            return 0;
        }
    };
    PriorityQueue<Order> Q = new PriorityQueue(c);
    private Order o;
    public void add(Order order) {
        Q.add(order);
    }

    public Order get() {
        return Q.poll();
    }

    public static void main(String[] args) {
        Order o1 = new Order(23456);
        Order o2 = new Order(2346);
        Order o3 = new Order(18456);
        Order o4 = new Order(124);
        Order o5 = new Order(12000);
        Order o6 = new Order(12000);
        Order o7 = new Order(12000);
        OrderQueue TEST = new OrderQueue();
        TEST.add(o1);
        TEST.add(o2);
        TEST.add(o3);
        TEST.add(o6);
        TEST.add(o7);
        TEST.add(o4);
        TEST.add(o5);
        System.out.println(TEST.get());
        System.out.println(TEST.get());System.out.println(TEST.get());System.out.println(TEST.get());System.out.println(TEST.get());System.out.println(TEST.get());System.out.println(TEST.get());System.out.println(TEST.get());System.out.println(TEST.get());
    }
}
