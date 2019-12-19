package ru.progwards.java1.lessons.interfaces;

public class ArraySort {
    public static void sort(int[] a){
        int i = 0; int j = 0; int t = 0;
                for (i = 0; i < a.length; i++) {
                    for (j = i+1; j < a.length; j++){
                        if (a[i] > a[j]) {
                            t = a[i];
                            a[i] = a[j];
                            a[j] = t;
                        }
                    }
                }
            }
            public static void main(String[] args) {
                int i = 0;
                int a[] = {2, 6, 19, -14, -3, 0};
                sort(a);
                for (i = 0; i < a.length; i++)
                System.out.println(a[i]);
            }
        }
