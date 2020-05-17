package ru.progwards.java2.lessons.generics;

public class DynamicArray <T>{
    private T[] array; int num;
    DynamicArray() {
        this.array = (T[]) new Object [8];
        num = 0;
    }
    DynamicArray(T[]array) {
    this.array = array;
    num = array.length;
    }
    public void doubler() {
         T[] newArr = (T[]) new Object[this.array.length * 2];
         for (int i = 0; i < this.array.length; i++) newArr[i] = this.array[i];
        this.array = newArr;
    }
    public void add(T e){
        if (array.length == num) this.doubler();
        array[num] = e; num++;
    }
    public void insert (int pos, T e){
        if (array.length == num) this.doubler();
        for (int i = num-1; i >= pos; i--) array[i+1] = array[i];
        array[pos] = e; num++;
    }
    public void remove (int pos){
        for (int i = pos; i < num; i++) array[i] = array[i+1];
        num--;
    }
    public T get(int pos) {
        return array[pos];
    }
    public int size() {
        return num;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> D = new DynamicArray<>();
        D.add(5);D.add(9);D.add(5567);D.add(465);D.add(33);
        System.out.println(D.size());
        D.remove(0);
        System.out.println(D.get(0));
        System.out.println(D.size());
        System.out.println(D.get(1));
        System.out.println(D.get(4));
    }
}
