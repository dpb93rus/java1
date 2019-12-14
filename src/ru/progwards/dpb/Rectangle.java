package ru.progwards.dpb;

import java.util.Objects;

public class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a*b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.a, a) == 0 && Double.compare(rectangle.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public int compareTo (Rectangle anRectangle) {
        if (this.area()==anRectangle.area())
            return 0;
            if (this.area()>anRectangle.area())
                return 1;
            else return -1;
        }

    public static void main(String[] args) {
        Rectangle a = new Rectangle(2,4);
        Rectangle b = new Rectangle(8,1);
        System.out.println(a.compareTo(b));

    }
}