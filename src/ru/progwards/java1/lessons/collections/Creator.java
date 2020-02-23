package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Creator {
    public static Collection<Integer> fillEven(int n){
        ArrayList <Integer> x = new ArrayList<>();
        int a = 2;
        while (x.size() < n) {
            x.add(a);
            a +=2;
        }
        return x;
    }

    public static Collection<Integer> fillOdd(int n){
        ArrayList <Integer> x = new ArrayList<>();
        int a = 2 * n - 1;
        while (x.size() < n) {
            x.add(a);
            a -= 2;
        }

        return x;
    }

    public static Collection<Integer> fill3(int n){
        ArrayList <Integer> x = new ArrayList<>();
        int a = 0;
        while (x.size() < (n*3)) {
            x.add(a);
            x.add(a*a);
            x.add(a*a*a);
            a+=3;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(fillEven(5));
        System.out.println(fillOdd(7));
        System.out.println(fill3(5));
    }
}
