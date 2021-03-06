package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    static CacheInfo lastFibo = new CacheInfo();

    // расчет числа фибоначчи по его порядковому номеру
    public static int fiboNumber(int n) {

        if ( lastFibo.n == n)
            return lastFibo.fibo;
        int x = 0;
        int y = 1;
        int z = 0;
        int count = 1;
        while (n != count) {
            z = x;
            x = y;
            y = y + z;
            count++;
        }
        lastFibo.fibo = y;
        lastFibo.n = n;
        return y;
    }
    public static CacheInfo getLastFibo() {
        return lastFibo;
    }
    public static void clearLastFibo() {
        lastFibo = new CacheInfo();
    }
    public static class CacheInfo {
        public int n; //порядковый номер числа фибоначчи
        public int fibo; //число фибоначи с номером n
    }
    public static void main(String[] args) {
        System.out.println(fiboNumber(6));
        System.out.println(fiboNumber(6));
        clearLastFibo();

    }


}
