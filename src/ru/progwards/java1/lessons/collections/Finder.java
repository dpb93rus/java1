package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers){
        ArrayList <Integer> x = new ArrayList<>(numbers);
        int a = 0; int n = 0; int z = 0;
        if ((x.get(n + 1) + x.get(n + 2)) < (x.get(n) + x.get(n + 1))) z = n + 1;
        else z = n;
        for (n = 1; n < x.size()-2; n++) {
            if ((x.get(n + 1) + x.get(n + 2)) < (x.get(z) + x.get(z + 1))) z = n + 1;
        }
        x.clear(); x.add(z); x.add(z+1);
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
          z.add(-6);z.add(-64);z.add(80);z.add(-33);z.add(0);z.add(-97);z.add(52);z.add(23);z.add(-82);z.add(-8);z.add(-80);z.add(-31);z.add(52);z.add(-38);z.add(19);z.add(84);z.add(-74);z.add(34);
          System.out.println(findMinSumPair(z));
          System.out.println(findLocalMax(z));
          System.out.println(findSequence(z));
          System.out.println(findSimilar(q));
    }
}
