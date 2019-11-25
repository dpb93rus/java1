package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        byte count = 0;
        while (value > 0) {
            if ((value & 0b00000001) == 0b00000001) {
                count += 1;
            }
            value >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b01010111));
    }
}
