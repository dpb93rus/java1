package ru.progwards.java1.lessons.basic;

public class AccuracyDoubleFloat {
    public static double volumeBallDouble(double radius){
        double v = 4/3*3.14*radius*radius*radius;
        return v;
    }
    public static float volumeBallFloat(float radius){
        float p = 3.14f;
        float v = 4/3*p*radius*radius*radius;
        return v;
    }
    public static double calculateAccuracy(double radius){
        double x = volumeBallDouble(radius);
        double y = volumeBallFloat((float)radius);
        double z = x-y;
        return z;
    }

    public static void main(String[] args) {
        double x = volumeBallDouble(6371.2);
        double y = volumeBallFloat(6371.2f);
        double z = calculateAccuracy(6371.2);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}
