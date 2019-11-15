package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {

    public static int maxSide(int a, int b, int c) {
        int max1 = a;
        if ((a>=b)&(a>=c)) {
            ;
        }
         else {
            if ((a<=b)&(b>=c)) {
                max1 = b;
            } else {
                max1 = c;
            }
                return max1;
        }
    }
    public static int minSide(int a, int b, int c) {
        int min = a;
        if ((a>=b)&(b<=c)) {
            min = b;
        }
        else {
            if ((a<=b)&(a<=c)) {
                min = a;
            } else {
                min = c;
            }
            return min;
        }
    }
    public static boolean isEquilateralTriangle(int a, int b, int c) {
        boolean r;
        if ((a==b)&&(a==c)) {
            r = true;
        } else {
            r = false;
            }
            return r;
        }

    public static void main(String[] args) {
        int a = maxSide();
        int b = minSide();
        boolean r = isEquilateralTriangle();
        System.out.println(a);
        System.out.println(b);
        System.out.println(r);
    }
}
