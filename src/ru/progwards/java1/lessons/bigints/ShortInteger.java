package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ShortInteger extends AbsInteger {


    ShortInteger(short n) {
        super((long) n);
    }
    @Override
    public String toString() {
        return "ShortInteger{" +
                "n=" + n +
                '}';
    }
}

