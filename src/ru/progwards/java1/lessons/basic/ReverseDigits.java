package ru.progwards.java1.lessons.basic;

public class ReverseDigits {
    public static int reverseDigits(int number){
        int a = number/100;
        int b = number%100/10;
        int c = number%10;
        int result = c*100+b*10+a;
        return result;
    }
    public static void main(String[] args) {
        int result = reverseDigits(123);
        System.out.println(result);
    }
}
