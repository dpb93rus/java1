package ru.progwards.java1.lessons.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int pos;

    ArrayIterator(T[] array) {
        this.array = array;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        if (pos < array.length) return true;
        return false;
    }

    @Override
    public T next() {
        if (this.hasNext() == true) {
            pos++;
            return array[pos - 1];
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] A = {12, 1, 214, 3242, 4, 234, 24, 2, 4, 34, 432, 4, 23, 42, 43, 432, 432, 243, 4322, 43, 432,};
        ArrayIterator<Integer> iterator = new ArrayIterator<>(A);
        System.out.println(iterator.hasNext());
        int[][] B = {{12, 1}, {214, 3242},{ 4, 8, 234,8}, {2, 4}};
        System.out.println(B[2].length);
    }
}