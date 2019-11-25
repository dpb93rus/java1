package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {
    public static int checkBit(byte value, int bitNumber){
        value >>= bitNumber;
        value &= 0b00000001;
        return value;
    }

    public static void main(String[] args) {
        System.out.println(checkBit((byte)0b01011001,0));
    }
}
