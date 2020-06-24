//package ru.progwards.java2.lessons.gc;
//
//public class HeapArray {
//    byte[] bytes;
//    byte[] heap;
//    byte size;
//    boolean flag;
//
//    HeapArray(int maxHeapSize) {
//        size = (byte) maxHeapSize;
//        bytes = new byte[size];
//        heap = new byte[size];
//        flag = false;
//        for (byte i = 0; i < size; i++) {
//            heap[i] = (byte) (size - i);
//        }
//    }
//
//    public int malloc(byte size) throws OutOfMemoryException {
//        for (byte i = 0; i < size; i++) {
//            if (heap[i] < 0) {
//                i -= (heap[i] - 1);
//                continue;
//            }
//            if (heap[i] == 0) continue;
//            if (heap[i] >= size) {
//                heap[i] = (byte) -size;
//                for (int n = i + 1; n <= i + size; n++) {
//                    heap[n] = 0;
//                }
//                return i;
//            }
//        }
//        if (!flag) {
//            compact();
//            flag = true;
//            return malloc(size);
//        } else {
//            flag = false;
//            throw new OutOfMemoryException("Невозможно разместить блок");
//        }
//    }
//
//
//    public void free(byte ptr) throws InvalidPointerException {
//        if (heap[ptr] <= 0) throw new InvalidPointerException("Указатель ссылается на занятый ранее блок");
//        byte numberOfNextByte = (byte) (ptr - heap[ptr]);
//        byte nextByte = heap[numberOfNextByte];
//        if (nextByte > 0) {
//            byte i = (byte) (nextByte - 1);
//            byte count = 1;
//            while (i >= ptr) {
//                heap[i] = (byte) (nextByte + count);
//                count++;
//            }
//        }
//    }
//
//    public void compact() throws OutOfMemoryException {
//        HeapArray compactHeapArray = new HeapArray(size);
//        for (byte i = 0; i < size; i++) {
//            if (heap[i] < 0) {
//                compactHeapArray.malloc((byte) -heap[i]);
//                for (byte n = i; n < i - heap[i]; n++) {
//
//                }
//                i -= (heap[i] - 1);
//
//            }
//        }
//    }
//}
