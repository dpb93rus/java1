package ru.progwards.java2.lessons.basetypes;

import javax.swing.text.Element;
import java.io.UncheckedIOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class BiDirList<T> {
    Element<T> eZero, eLast;
    int size;

    public static class Element<T> {
        public T e;
        Element<T> eNext, ePrevious;

        Element(T el, Element<T> ePr, Element<T> eN) {
            e = el;
            ePrevious = ePr;
            eNext = eN;
        } //Конструктор элемента

        public boolean hasNext() {
            if (eNext == null) return false;
            return true;
        }
    }

    public BiDirList() {
        eZero = eLast = null;
        size = 0;
    }

    public static <T> BiDirList<T> from(T[] array) {
        BiDirList<T> list = new BiDirList<>();
        for (T t : array) list.addLast(t);
        return list;
    }

    public static <T> BiDirList<T> of(T... array) {
        BiDirList<T> list = new BiDirList<>();
        for (T t : array) list.addLast(t);
        return list;
    }

    public int size() {
        return size;
    }

    public void addLast(T item) {
        Element<T> e;
        if (this.size != 0) {
            e = new Element<>(item, eLast, null);
            e.ePrevious.eNext = e;
        } else {
            e = new Element<>(item, null, null);
            eZero = e;
        }
        eLast = e;
        this.size++;
    }

    public void addFirst(T item) {
        if (this.size != 0) {
            Element<T> e = new Element<>(item, null, eZero);
            e.eNext.ePrevious = e;
            eZero = e;
        } else {
            Element<T> e = new Element<>(item, null, null);
            eZero = e;
            eLast = e;
        }
        this.size++;

    }

    //    public void removeOnlyOne(T item) {
//        if (this.size == 0) System.err.println("This list is empty");
//        else {
//            if (eZero.e.equals(item)) {
//                eZero = eZero.eNext;
//                eZero.ePrevious = null;
//                size--;
//                return;
//            }
//            Element<T> t = eZero;
//            for (int i = 0; i < this.size; i++) {
//                t = t.eNext;
//                if (t.e.equals(item)) {
//                    if (t.eNext != null) {
//                        t.eNext.ePrevious = t.ePrevious;
//                        t.ePrevious.eNext = t.eNext;
//                    } else {
//                        t.ePrevious.eNext = null;
//                        eLast = eLast.ePrevious;
//                    }
//                    size--;
//                    return;
//                }
//
//            }
//        }
//        System.out.println("Element not exist");
//    }
    public void removeOnlyOneFirst(T item) {
        if (size == 0) {
            System.err.println("This list is empty");
            return;
        }
        if (size == 1 & item.equals(eZero.e)) {
            eZero = null;
            eLast = null;
            size--;
            return;
        }
        if (size != 1 & item.equals(eZero.e)) {
            eZero = eZero.eNext;
            eZero.ePrevious = null;
            size--;
            return;
        }
        Element<T> element = eZero.eNext;
        for (int i = 1; i < size; i++) {
            if (item.equals(element.e)) {
                if (eLast != element) {
                    element.ePrevious.eNext = element.eNext;
                    element.eNext.ePrevious = element.ePrevious;
                } else {
                    element.ePrevious.eNext = element.eNext;
                    eLast = element.ePrevious;
                }
                size--;
                return;
            }
            element = element.eNext;
        }
    }

    public void remove(T item) {
        int a = size;
        removeOnlyOneFirst(item);
        if (size < a) remove(item);
    }

    public T at(int i) {
        if (i >= 0 & i < size) {
            Element<T> t;
            if (i < size / 2) {
                t = eZero;
                for (int c = 0; c < size / 2; c++) {
                    if (c == i) return t.e;
                    t = t.eNext;
                }
            } else {
                t = eLast;
                for (int c = size - 1; c >= size / 2; c--) {
                    if (c == i) return t.e;
                    t = t.ePrevious;
                }
            }

        } else throw new IndexOutOfBoundsException();
        return null;
    }

    public static <T> void toArray(BiDirList<T> list, T[] array) {
        if (list.size == 0) return;
        if (array.length < list.size) {
            System.err.println("Array length less that list size");
            return;
        }
        T t = list.eZero.e;
        for (int i = 0; i < list.size; i++) {
            array[i] = t;
        }
    }


    public static class Iterator<T> {
        BiDirList<T> list;
        Element<T> element;

        Iterator(BiDirList<T> list) {
            this.list = list;
            element = this.list.eZero;
        }

        public boolean hasNext() {
            if (element != null) return true;
            return false;
        }

        public T next() {
            if (this.hasNext()) return element.e;
            throw new NoSuchElementException();
        }

        public void remove() {
            list.removeOnlyOneFirst(element.e);
        }

        public Iterator<T> getIterator() {
            return new Iterator<T>(list);
        }

        public static void main(String[] args) {
            BiDirList<String> alpha = new BiDirList<>();
            alpha.addLast("String 1");
            alpha.addLast("String 2");
            alpha.addLast("String 3");
            alpha.addLast("String 0");
            alpha.addLast("String 0");
            alpha.addFirst("String 0");
            alpha.addLast("String 1");
            alpha.addLast("String 2");
            alpha.addLast("String 3");
            alpha.addLast("String 0");
            alpha.addLast("String 0");
            alpha.addFirst("String 0");
//            alpha.addFirst("String 2");
            alpha.remove("String 0");
            System.out.println(alpha.size);
        }
    }
}
