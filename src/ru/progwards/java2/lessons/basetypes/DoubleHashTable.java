package ru.progwards.java2.lessons.basetypes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleHashTable<K extends HashValue, V> {
    Element<K, V>[] doubleHashTable;
    int size;
    int absSize;


    public class Element<K, V> {
        K key;
        V value;
        boolean delMark;

        Element(K key, V value) {
            this.key = key;
            this.value = value;
            delMark = false;
        }

        Element() {
            this.key = null;
            this.value = null;
            this.delMark = true;
        }
    }

    DoubleHashTable() {
        doubleHashTable = new Element[5];
        size = 0;
        absSize = 5;
    }

    static int size(DoubleHashTable a) {
        return a.size;
    }

    static int getAbsSize(DoubleHashTable a) {
        return a.absSize;
    }

    private void doubleSize() {
        int absDoubleSize = MyMath.doubleHighSimple(absSize);
        Element<K, V> doubleTable[] = new Element[absDoubleSize];
        for (int i = 0; i < absSize; i++) {
            if (doubleHashTable[i] == null || doubleHashTable[i].delMark) continue;
            int hashCode = doubleHashTable[i].key.getHash(absDoubleSize);
            if (doubleTable[hashCode]==null) { doubleTable[hashCode] = doubleHashTable[i]; continue; }
            for (int probe = 0; probe <= absDoubleSize / 5; probe++) {
                int deepHash = MyMath.deepHash(hashCode + probe + 1, absSize);
                if (doubleTable[deepHash]==null) {
                    doubleTable[deepHash] = doubleHashTable[i];
                    break;
                }
            }
        }
        doubleHashTable = doubleTable;
        absSize = absDoubleSize;
    }

    private void halfSize() {
        int absHalfSize = MyMath.halfHighSimple(absSize);
        Element<K, V> halfTable[] = new Element[absHalfSize];
        for (int i = 0; i < absSize; i++) {
            if (doubleHashTable[i] == null || doubleHashTable[i].delMark) continue;
            halfTable[doubleHashTable[i].key.getHash(absHalfSize)] = doubleHashTable[i];
        }
        doubleHashTable = halfTable;
        absSize = absHalfSize;
    }

    public V get(K key) {
        int hashCode = key.getHash(absSize);
        if (doubleHashTable[hashCode] != null && key.equals(doubleHashTable[hashCode].key))
            return doubleHashTable[hashCode].value;
        for (int probe = 0; probe <= absSize*10; probe++) {
            int deepHash = MyMath.deepHash(hashCode + probe, absSize);
            if (doubleHashTable[deepHash] != null && key.equals(doubleHashTable[deepHash].key))
                return doubleHashTable[deepHash].value;
        }
        return null;
    }

    public void remove(K key) {
        V temp = get(key);
        if (temp != null) {
            int hashCode = key.getHash(absSize);
            if (key.equals(doubleHashTable[hashCode].key)) {
                doubleHashTable[hashCode] = new Element<>();
                size--;
                if (size < absSize / 5) this.halfSize();
                return;
            }
            for (int probe = 0; probe <= absSize / 5; probe++) {
                int deepHash = MyMath.deepHash(hashCode + probe, absSize);
                if (key.equals(doubleHashTable[deepHash].key)) {
                    doubleHashTable[deepHash] = new Element<>();
                    size--;
                    if (size < absSize / 5) this.halfSize();
                    return;

                }
            }
        }
        throw new NoSuchElementException();
    }

    public void add(K key, V value) {
        V temp = get(key);
        int hashCode = key.getHash(absSize);
        if (temp != null) {
            if (key.equals(doubleHashTable[hashCode].key)) {
                doubleHashTable[hashCode] = new Element<>(key, value);
                return;
            } else {
                for (int probe = 0; probe <= absSize / 10; probe++) {
                    int deepHash = MyMath.deepHash(hashCode + probe, absSize);
                    if (key.equals(doubleHashTable[deepHash].key)) {
                        doubleHashTable[deepHash] = new Element<>(key, value);
                        return;
                    }
                }
            }
        } else {
            if (doubleHashTable[hashCode] == null || doubleHashTable[hashCode].delMark) {
                doubleHashTable[hashCode] = new Element<>(key, value);
                size++;
                return;
            }
            for (int probe = 0; probe <= absSize / 10; probe++) {
                int deepHash = MyMath.deepHash(hashCode + probe, absSize);
                if (doubleHashTable[deepHash] == null || doubleHashTable[deepHash].delMark) {
                    doubleHashTable[deepHash] = new Element<>(key, value);
                    size++;
                    return;
                }
            }
        }
        doubleSize();
        add(key, value);
    }

    public void change(K key1, K key2) {
        V tempValue = get(key1);
        remove(key1);
        add(key2, tempValue);
    }

    public Iterator<Element<K, V>> getIterator() {
        return new Iterator<Element<K, V>>() {
            int pos = 0;

            @Override
            public boolean hasNext() {
                if (pos < size) return true;
                return false;
            }

            @Override
            public Element<K, V> next() {
                if (hasNext()) {
                    for (int i = 0; pos < absSize; pos++) {
                        if (doubleHashTable[pos] == null || doubleHashTable[pos].delMark) continue;
                        return doubleHashTable[pos];
                    }
                }
                return null;
            }
        };
    }


    public static void main(String[] args) {
        DoubleHashTable<MyString, Integer> q = new DoubleHashTable<>();
        for (int i = 0; i < 150; i++) {
            MyString a = new MyString(i + "Key");
            q.add(a, i);
        }
        for (int i = 0; i < getAbsSize(q); i++) {
            if (q.doubleHashTable[i] == null) System.out.println("null");
            else System.out.println(q.doubleHashTable[i].value);

        }
        System.out.println("");
        System.out.println(size(q));
        System.out.println(q.absSize);
        System.out.println("");
        for (int i = 0; i < getAbsSize(q); i++) {
            System.out.println(q.get(new MyString(i + "Key")));
        }
    }
}