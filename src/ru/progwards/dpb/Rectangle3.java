package ru.progwards.dpb;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Rectangle3 {
    public static Set<Integer> a2set(int[] a) {
        HashSet<Integer> res = new HashSet();
        for (Integer t : a) {
            res.add(t);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] b = {23,23,554,56,654,6,545,645,6,6545,45,6,54,45,445};
        System.out.println(a2set(b));
    }
}