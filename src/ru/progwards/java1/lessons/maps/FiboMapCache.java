package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    boolean cacheOn;
    private Map<Integer, BigDecimal> fiboCache;

    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
    }

    public BigDecimal fiboNumber(int n) {
        if (fiboCache == null)
             fiboCache = new HashMap<>();
        if (cacheOn & fiboCache.containsKey(n))
             return fiboCache.get(n);
        BigDecimal x = BigDecimal.ZERO;
        BigDecimal y = BigDecimal.ONE;
        BigDecimal z = BigDecimal.ZERO;;
        int count = 1;
        while (n != count) {
            z = x;
            x = y;
            y = y.add(z);
            count++;
        }
        if (cacheOn) fiboCache.put(n, y);
        return y;
    }

    public void clearCahe() {
        fiboCache = null;
    }

    public static void test() {
        FiboMapCache cashOn = new FiboMapCache(true);
        FiboMapCache cashOff = new FiboMapCache(false);
        long b = System.nanoTime();
        for (int n = 1; n <= 1000; n++) cashOn.fiboNumber(n);
        for (int n = 1; n <= 1000; n++) cashOn.fiboNumber(n);
        b = System.nanoTime() - b;
//        cashOff.clearCahe();
        long a = System.nanoTime();
        for (int n = 1; n <= 1000; n++) cashOff.fiboNumber(n);
        for (int n = 1; n <= 1000; n++) cashOff.fiboNumber(n);
        a = System.nanoTime() - a;

        System.out.println("fiboNumber cacheOn=" + cashOn.cacheOn + " время выполнения     " + b);
        System.out.println("fiboNumber cacheOn=" + cashOff.cacheOn + " время выполнения    " + a);

    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("456d6675"));

    }
}
