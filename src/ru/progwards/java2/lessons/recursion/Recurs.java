package ru.progwards.java2.lessons.recursion;

import java.util.ArrayList;
import java.util.List;

public class Recurs {

    //    static String reverseChars(String str) {
//        if (str.length() == 1) return str;
//        return reverseChars(str.substring(1,str.length()))+(str.substring(0,1));
//    }
    public static <T> ArrayList from(T[] args) {
        ArrayList<T> a = new ArrayList<>();
        for (T e : args) a.add(e);
        return a;
    }
    public static <T> void swap (List<T> a, int i1, int i2) {
        T t;
        t = a.get(i1);
        a.set(i1, a.get(i2));
        a.set(i2,t);
    }

    public static void main(String[] args) {
        String a[] = new String[]{"dytry", "ghkgkh"};
        System.out.println(from(a));
    }
}
//    void sortAndPrint(List<Person> list) {
//        list.sort(Comparator.comparing(a -> a.age));
//        list.forEach(e -> System.out.println (e));
//    }