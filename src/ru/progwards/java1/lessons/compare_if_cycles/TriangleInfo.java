package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c) {
        boolean e;
        if (((a + b) > c) || ((a + c) > b) || ((b + c) > a)) {
            e = true;
        } else {
            e = false;
        }
        return e;
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        boolean p;
        if (((a + b) * (a + b) == (c * c) || ((a + c) * (a + c) == (b * b)) || ((b + c) * (b + c)) == (a * a))) {
            p = true;
        } else {
            p = false;
        }
        return p;
    }

    public static boolean isRightTriangleisRightTriangle(int a, int b, int c) {
        boolean r;
        if ((a == b) || (a == c) || (b == c)) {
            r = true;
        } else {
            r = false;
        }
        return r;
    }

    public static void main(String[] args) {
        boolean e = isTriangle();
        boolean p = isRightTriangle();
        boolean r = isRightTriangle();
        System.out.println(e);
        System.out.println(p);
        System.out.println(r);
    }
}

