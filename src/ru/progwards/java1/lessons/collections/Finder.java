package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers){
        ArrayList <Integer> x = new ArrayList<>(numbers);
        int a = 0; int b = 0; int n = 0; int c = n;int d = 1;
        while (n < (x.size()-2)) {
        a = x.get(n); b = x.get(n+1);
        if ((x.get(c) + x.get(d)) > (b + x.get(n+2))) {
            a = b; b = x.get(n+2); c=d; d=d+1;
            }
            n++;
        }
        x.clear(); x.add(c); x.add(d);
        return x;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers){
        ArrayList <Integer> x = new ArrayList<>(numbers);
        ArrayList <Integer> y = new ArrayList<>();
        for (int n = 1; n < (x.size()-1); n++) {
            if (((x.get(n)) > (x.get(n-1))) & ((x.get(n)) > (x.get(n+1))))
                y.add(x.get(n));
        }
        return y;
    }

    public static boolean findSequence(Collection<Integer> numbers){
        ArrayList <Integer> x = new ArrayList<>(numbers);
        ArrayList <Integer> y = new ArrayList<>();
        for (int n = 0; n < x.size();n++) y.add(n+1);
        for (int n = 0; n < x.size();n++) {
            if ((x.contains(y.get(n)) == false)) return false;
        }
        return true;
        }


    public static String findSimilar(Collection<String> names) {
        ArrayList<String> x = new ArrayList(names);
        int count = 1;
        int count2 = 1;
        String temp = "";
        String temp2 = "";
        for (int n = 0; n < x.size()-1; n++) {
            if (x.get(n).equals(x.get(n + 1)) == true) {
                count++;
                temp = x.get(n);
            } else {
                if (count > count2) {
                    count2 = count;
                    count = 1;
                    temp2 = temp;
                }
            }
        }
        return temp2+":"+count2;
    }




      public static void main(String[] args) {
          ArrayList <Integer> z = new ArrayList<>();
          ArrayList<String> q = new ArrayList();
          q.add("wwwwww");q.add("zzzzz");q.add("zzzzz");q.add("zzzzz");q.add("wwwwww");q.add("t");q.add("u");q.add("u");q.add("u");q.add("oooio");q.add("wwwwww");
          z.add(1);z.add(2);z.add(11);z.add(5);z.add(3);z.add(6);z.add(4);z.add(7);z.add(55);z.add(9);
          System.out.println(findMinSumPair(z));
          System.out.println(findLocalMax(z));
          System.out.println(findSequence(z));
          System.out.println(findSimilar(q));
    }
}
