package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    static CacheInfo lastFibo;


    public static int fiboNumber(int n) {
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
        return y;
        }

    public static class CacheInfo {
        public int n; public int fibo;

        }
    public static void main(String[] args) {


        }


        }
