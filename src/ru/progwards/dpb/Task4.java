package ru.progwards.dpb;

public class Task4 {
    static double fractional (double num) {
        double v = num % 1;
        return v;
    }

    public static void main(String[] args) {
        double z = fractional(33423.5464);
        System.out.println(z);
    }
}