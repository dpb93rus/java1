package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    public static boolean containsDigit(int number, int digit) {
        boolean f = false;
        int ost = 0;
        if (number == digit) {
            f = true;
        } else {
        while ((number > 0)&&(f != true)) {
            ost = number % 10;
            if (ost == digit) {
                f = true;
            }
                number = number / 10;
            }
        }
            return f;
    }

    public static int fiboNumber(int n) {
        int x = 0;
        int y = 1;
        int z = 0;
        int count = 1;
        while (n != count) {
            z = x;
            x = y;
            y = y + z;
            count++;
        }
        return y;
        }

    public static boolean isGoldenTriangle (double a, double b, double c) {
        boolean r = false;
        if (((a==b)&((a/c)>1.61703)&((a/c)<1.61903))||((a==c)&((a/b)>1.61703)&((a/b)<1.61903))||((b==c)&((b/a)>1.61703)&((b/a)<1.61903))) {
        r = true;
        } else {
        r = false;
        }
        return r;
        }

    public static void main(String[] args) {
        System.out.println(containsDigit(0, 0));
        int a = 1;
        int b = 1;
        int c = 1;
        int count = 1;
        do {
            System.out.println(fiboNumber(count));
            count++;
        }
        while (count <= 15);
        count = 1;
        int count2 = 1;
        while (fiboNumber(count) <= 100) {
            while (fiboNumber(count2) <= 100) {
                a = fiboNumber(count);
                b = fiboNumber(count);
                c = fiboNumber(count2);
                if (isGoldenTriangle(a, b, c) == true) {
                    System.out.print(a);
                    System.out.print(b);
                    System.out.println(c);
                } else {
                    count2++;
                }
            }
            count++;
        }


        }
    }
