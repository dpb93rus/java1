package ru.progwards.java2.lessons.generics;

import java.util.Comparator;

public class ArraySort <T> {
    public static <T extends Comparable> void sort (T [] a){
        int i = 0; int j = 0; T t;
        for (i = 0; i < a.length; i++) {
            for (j = i+1; j < a.length; j++){
                T a1 = (T)a[i]; T a2 = (T)a[j];
                if (a[i].compareTo(a[j]) > 0) {
                    t = a[i];
                    a[i] = a[j];
                    a[j] = (T)t;
                }
            }
        }
    }
    public static void main(String[] args) {
        int i = 0;
        Double a[] = {2.0, 6.0, 19.0, -14.0, -3.0, 0.0};
        ArraySort.sort(a);
        for (i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}
