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
          if ((cacheOn)&(fiboCache==null)) fiboCache = new HashMap<Integer, BigDecimal>();
          if ((cacheOn)&(fiboCache.containsKey(n))) return fiboCache.get(n);
          BigDecimal x = new BigDecimal("0");
          BigDecimal y = new BigDecimal("1");
          BigDecimal z = new BigDecimal("0");
          int count = 1;
          while (n != count) {
               z = x;
               x = y;
               y = y.add(z);
               count++;
          }
          fiboCache.put(n, y);
          return y;
     }
     public void clearCahe() {
          fiboCache = null;
          }

     public static void test() {
          FiboMapCache cashOn = new FiboMapCache(true);
          FiboMapCache cashOff = new FiboMapCache(true);
          long a = System.nanoTime();
          for (int n = 1; n <= 1000; n++) cashOff.fiboNumber(n);
          a = System.nanoTime() - a;
          long b = System.nanoTime();
          for (int n = 1; n <= 1000; n++) cashOn.fiboNumber(n);
          b = System.nanoTime() - b;




          System.out.println("fiboNumber cacheOn="+b);
          System.out.println("fiboNumber cacheOff="+a);
     }

     public static void main(String[] args) {
     test();
     }
}
