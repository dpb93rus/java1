package ru.progwards.java2.lessons.gc;

import java.util.*;

public class Heap {

    byte[] bytes;
    HashMap<Integer, Integer> heap;
    TreeMap<Integer, Integer> freeBlocks;
    int size;
    boolean optimized;

    Heap(int maxHeapSize) {
        size = maxHeapSize;
        bytes = new byte[size];
        for (int i = 0; i < size; i++) bytes[i] = (byte)i;
        heap = new HashMap<>();
        freeBlocks = new TreeMap<>();
        freeBlocks.put(0, size);
        optimized = false;
        }

    public int malloc(int size) throws OutOfMemoryException {
        Map.Entry <Integer, Integer> temp = new AbstractMap.SimpleEntry<>(-1,this.size+1);
        for (Map.Entry<Integer, Integer> e: freeBlocks.entrySet()) {
            if (e.getValue() >= size && e.getValue() < temp.getValue()) {
                temp = new AbstractMap.SimpleEntry<>(e);
                if (temp.getValue() == size) {
                    heap.put(temp.getKey(),size);
                    freeBlocks.remove(temp.getKey());
                    optimized = false;
                    return temp.getKey();
                }
            }
        }
        if (temp.getKey()!=(-1)) {
            heap.put(temp.getKey(),size);
            freeBlocks.remove(temp.getKey());
            freeBlocks.put(temp.getKey()+size, temp.getValue()-size);
            optimized = false;
            return temp.getKey();
        }
        if (!optimized) {
            compact();
            optimized = true;
            return malloc(size);
        }
        else {
            optimized = false;
            throw new OutOfMemoryException("Невозможно разместить блок");
        }

    }

    public void getSize(int index) {
        if (heap.containsKey(index)) System.out.println("По индексу "+index+" найден объект занимающий "+ heap.get(index) + " байт" );
        else if (freeBlocks.containsKey(index)) System.out.println("По индексу "+index+" найден свободный блок памяти занимающий "+ freeBlocks.get(index) + " байт" );
        else System.out.println("Индекс "+index+" не является началом свободного блока памяти или объекта" );
    }

    public void free(int ptr) throws InvalidPointerException {
        if (heap.containsKey(ptr)) {
            freeBlocks.put(ptr, heap.get(ptr));
            heap.remove(ptr);
        }
        else throw new InvalidPointerException("Неверный указатель");
    }

    public void defrag() {
        if (freeBlocks.size() < 2) return;
        List <Map.Entry <Integer, Integer>> temp = new ArrayList<>(freeBlocks.entrySet());
        for (int i = 0; i < temp.size()-1; i++) {
            if (temp.get(i).getKey()+temp.get(i).getValue() == temp.get(i+1).getKey()) {
                temp.add(new AbstractMap.SimpleEntry<>(temp.get(i).getKey(), temp.get(i).getValue() + temp.get(i + 1).getValue()));
                temp.remove(i+1);
                i--;
            }
        }
        freeBlocks.clear();
        for (Map.Entry<Integer, Integer> t : temp) {
            freeBlocks.put(t.getKey(), t.getValue());
        }
    }


    public void compact() {
        byte[] compactedData = new byte[size];
        HashMap<Integer, Integer> compactedHeap = new HashMap<>();
        int countIndexFull = 0;
        for (Map.Entry<Integer, Integer> e: heap.entrySet()) {
            compactedHeap.put(countIndexFull,e.getValue());
            for (int t = e.getKey(); t < e.getKey()+e.getValue(); t++) {
                compactedData[countIndexFull] = bytes[t];
                countIndexFull++;
            }
        }
        bytes = compactedData;
        heap = compactedHeap;
        freeBlocks.clear();
        freeBlocks.put(countIndexFull, size - countIndexFull);
    }

    public void printData() {
        for (byte t: bytes) {
            System.out.print(t+ " | ");
        }
        System.out.println();
    }

    public void getBytes(int ptr, byte[] bytes) {
        System.arraycopy(this.bytes, ptr, bytes, 0, size);
    }

    public void setBytes(int ptr, byte[] bytes) {
        System.arraycopy(bytes, 0, this.bytes, ptr, size);
    }

    public static void main(String[] args) throws OutOfMemoryException, InvalidPointerException {
        Heap A = new Heap(18);
        System.out.println(A.size);
        A.malloc((byte)6);
        A.malloc((byte)6);
        A.malloc((byte)6);
        A.printData();
        A.free(6);
        A.free(0);
        A.defrag();
        A.getSize(0);
        A.getSize(1);
        A.getSize(2);
        A.getSize(3);
        A.getSize(4);
        A.getSize(5);
        A.getSize(6);
        A.getSize(7);
        A.getSize(8);
        A.getSize(9);
        A.getSize(10);
        A.getSize(11);
        A.getSize(12);
        A.getSize(13);
        A.getSize(14);
        A.getSize(15);
        A.getSize(16);
        A.getSize(17);
        A.compact();
        A.getSize(0);
        A.getSize(1);
        A.getSize(2);
        A.getSize(3);
        A.getSize(4);
        A.getSize(5);
        A.getSize(6);
        A.getSize(7);
        A.getSize(8);
        A.getSize(9);
        A.getSize(10);
        A.getSize(11);
        A.getSize(12);
        A.getSize(13);
        A.getSize(14);
        A.getSize(15);
        A.getSize(16);
        A.getSize(17);
    }
}
