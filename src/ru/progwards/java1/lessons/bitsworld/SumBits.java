package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        byte count = 0;
        while (count < 8) {
            if ((value & 0b00000001) == 0b00000001) {
                count ++;
            }
            value >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b10000000));
    }
}
