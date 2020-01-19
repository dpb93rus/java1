package ru.progwards.dpb;

import java.util.Objects;

public class Rectangle2 {
    private double a;
    private double b;

    public Rectangle2(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a*b;
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Rectangle rectangle = (Rectangle) anObject;
        if (Double.compare (this.area(), ((Rectangle) anObject).area())==0) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public int compareTo (Rectangle2 anRectangle) {
        if (this.area()==anRectangle.area())
            return 0;
            if (this.area()>anRectangle.area())
                return 1;
            else return -1;
        }

    public static void main(String[] args) {
        Rectangle2 a = new Rectangle2(2,4);
        Rectangle2 b = new Rectangle2(8,1);
        System.out.println(a.compareTo(b));

    }
}