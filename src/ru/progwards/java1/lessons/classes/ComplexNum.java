package ru.progwards.java1.lessons.classes;

public class ComplexNum {
    int a = 0, b = 0;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return (a + "+" + b + "i");
    }

    public ComplexNum add(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum(num1.a + num2.a, num1.b + num2.b);
    }
    public ComplexNum sub(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum(num1.a - num2.a, num1.b - num2.b);
    }
    public ComplexNum mul(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum(num1.a * num2.a - num1.b * num2.b, num2.a * num1.b + num1.a * num2.b);
    }
    public ComplexNum div(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum(((num1.a * num2.a + num1.b * num2.b) / (num2.a * num2.a + num2.b * num2.b)),((num2.a * num1.b - num1.a * num2.b)/(num2.a * num2.a + num2.b * num2.b)));
    }
    public static void main(String[] args) {
        ComplexNum a = new ComplexNum(5, 2);
        ComplexNum b = new ComplexNum(1, 1);
        System.out.println(a.add(a, b));
        System.out.println(a.sub(a, b));
        System.out.println(a.mul(a, b));
        System.out.println(a.div(a, b));
    }
}