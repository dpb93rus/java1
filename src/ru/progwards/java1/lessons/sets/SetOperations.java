package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2){
        HashSet <Integer>res = new HashSet<>(set1);
        res.addAll(set2);
        return res;

    }


public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
    HashSet res = new HashSet(set1);
    res.retainAll(set2);
    return res;

}

public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
    HashSet res = new HashSet(set1);
    res.removeAll(set2);
    return res;
}

public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        return difference(union(set1,set2),intersection(set1,set2));
}

    public static void main(String[] args) {
        Set a = Set.of(1,23,45,454,565,34);
        Set b = Set.of(1,45,78,56,46,666);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(union(a,b));
        System.out.println(intersection(a,b));
        System.out.println(difference(a,b));
        System.out.println(symDifference(a,b));
    }


}
