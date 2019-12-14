package ru.progwards.java1.lessons.arrays;
import java.util.Arrays;
public class DIntArray {
    private int a[] = {};

    DIntArray () {
    }
    public void add(int num){
        int [] b = new int [a.length+1];
        b[b.length-1] = num;
        a = b;
    }
    public void atInsert(int pos, int num) {
        int [] b = new int [a.length+1];
        System.arraycopy(a , 0 , b , pos - 1, b.length);
        System.arraycopy(a , pos + 1 , b , a.length, b.length);
        b[pos] = num;
        a = b;
    }
    public void atDelete(int pos) {
        int [] b = new int [a.length-1];
        System.arraycopy(a , 0 , b , pos - 1, b.length);
        System.arraycopy(a , pos + 1 , b , a.length, b.length);
        a = b;
    }
    public int at(int pos) {
    return a[pos];
    }

    public static void main(String[] args) {
    }
}
