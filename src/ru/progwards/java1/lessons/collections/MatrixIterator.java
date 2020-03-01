package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator <T> implements Iterator<T> {


    private T[][] array;
    private int pos;
    private T[] arr;

    MatrixIterator(T[][] array) {
        this.array = array;
        int g = 0;
        for (int n = 0; n < array.length; n++) {
            g += array[n].length;
        }
        arr = (T[])new Object[g];
        this.pos = 0;
    }
    @Override
    public boolean hasNext() {
        if (pos < this.arr.length) return true;
        return false;
    }

    @Override
    public T next() {
        if (this.hasNext() == true) {
            pos++;
            return arr[pos - 1];
        }
        return null;
    }
}
