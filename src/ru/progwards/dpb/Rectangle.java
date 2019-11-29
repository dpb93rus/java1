package ru.progwards.dpb;

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