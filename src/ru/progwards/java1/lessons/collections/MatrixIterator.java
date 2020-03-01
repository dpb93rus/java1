package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {


    private T[][] array;
    private int pos;
    private T[] arr;

    MatrixIterator(T[][] array) {
        this.array = array;
        int g = 0;
        for (int n = 0; n < array.length; n++) {
            g += array[n].length;
        }
        this.arr = (T[]) new Object[g];
        for (int l = 0; l < arr.length; l++) {
            for (int n = 0; n < array.length; n++) {
                for (int m = 0; m < array[n].length; m++) {
                    arr[l] = array[n][m];
                    l++;
                }
            }
        }
            this.pos = 0;
        }
        @Override
        public boolean hasNext () {
            if (pos < this.arr.length) return true;
            return false;
        }

        @Override
        public T next () {
            if (this.hasNext() == true) {
                pos++;
                return arr[pos - 1];
            }
            return null;
        }
        public static void main (String[]args){
            Integer[][] A = {{12, 1, 214}, {3242, 4, 234, 24}, {2, 4, 34, 432, 4, 23}, {42, 43, 432, 432, 243, 4322, 43, 432}};
            MatrixIterator<Integer> iterator = new MatrixIterator<>(A);
            System.out.println(iterator.hasNext());
            int[][] B = {{12, 1}, {214, 3242}, {4, 8, 234, 8}, {2, 4}};
            System.out.println(B[2].length);
            System.out.println(A.toString());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());


        }
    }
