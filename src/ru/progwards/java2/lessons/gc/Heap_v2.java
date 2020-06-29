//package ru.progwards.java2.lessons.gc;
//
//import java.util.HashMap;
//import java.util.TreeMap;
//import java.util.TreeSet;
//
//public class Heap_v2 {
//
//    byte[] bytes;
//    TreeSet<Block> heap;
//    TreeSet<Block> freeBlocks;
//    int size;
//    boolean optimized;
//
//    Heap_v2(int maxHeapSize) {
//        size = maxHeapSize;
//        bytes = new byte[size];
//        for (int i = 0; i < size; i++) bytes[i] = (byte)i;
//        heap = new HashMap<>();
//        freeBlocks = new TreeMap<>();
//        freeBlocks.put(0, size);
//        optimized = false;
//    }
//
//}
