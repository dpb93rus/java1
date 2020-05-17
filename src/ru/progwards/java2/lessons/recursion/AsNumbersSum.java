package ru.progwards.java2.lessons.recursion;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class AsNumbersSum {

    public static String asNumbersSum(int number) {
        String result = "";
        for (ArrayList<Integer> t: recurs(number)) {
            result += "=";
            for (Integer i: t) result += i + "+";
            result = result.substring(0,result.length()-1);
        }
        result = result.substring(1,result.length());
        return result;
    }

    public static ArrayList <ArrayList<Integer>> recurs(int number) {
        HashSet <ArrayList<Integer>> blustitelPoriadka = new HashSet<>();
        ArrayList <ArrayList<Integer>> result = new ArrayList<>();
        if (number == 0) return new ArrayList<ArrayList<Integer>>(List.of(new ArrayList<>(List.of())));
        if (number == 1) return new ArrayList<ArrayList<Integer>>(List.of(new ArrayList<>(List.of(1))));
        result.add(new ArrayList<>(List.of(number)));
        for (int n = number-1; n > 0; n--) {
            for (ArrayList<Integer> t : recurs(number-n)) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(n);
                arrayList.addAll(t);
                ArrayList<Integer> copy = new ArrayList<>(List.copyOf(arrayList));
                Collections.sort(copy);
                if (!blustitelPoriadka.contains(copy)) result.add(arrayList);
                blustitelPoriadka.add(copy);
            }
        }
        blustitelPoriadka.addAll(result);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(asNumbersSum(4));System.out.println(asNumbersSum(5));
        System.out.println(asNumbersSum(6));System.out.println(asNumbersSum(7));
    }
}