package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ByteInteger extends AbsInteger {


    ByteInteger(byte n) {
        super((long) n);

    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }

}

