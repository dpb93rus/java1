//package ru.progwards.java2.lessons.threads;
//
//public class Lesson implements Runnable{
//
//    private Counter counter;
//    public Lesson(Counter counter) {
//        this.counter = counter;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10000; i++)
//        counter.increase();
//    }
//
//
//
//    public static void main(String[] args) {
//    Counter counter = new Counter();
//    }
//
//    class Counter {
//        int count;
//        public void increase() {
//            count++;
//        }
//    }
//}
//
//
