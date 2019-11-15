package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c) {
        boolean e;
        if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)) {
            e = true;
        } else {
            e = false;
        }
        return e;
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        boolean p;
        if (((a * a) + (b * b) == (c * c) || ((a * a) + (c * c) == (b * b)) || ((b * b) + (c * c)) == (a * a))) {
            p = true;
        } else {
            p = false;
        }
        return p;
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        boolean r = false;
        if ((a == b) || (a == c) || (b == c)) {
            r = true;
        } else {
            r = false;
        }
        return r;
    }

    public static void main(String[] args) {
        boolean e = isTriangle(20,12,19);
        boolean p = isRightTriangle(2,5,4);
        boolean r = isIsoscelesTriangle(128,128,324);
        System.out.println(e);
        System.out.println(p);
        System.out.println(r);
    }
}

