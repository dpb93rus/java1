package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class IntInteger extends AbsInteger {


    IntInteger(int n) {
        super((long) n);
    }
    @Override
    public String toString() {
        return "IntInteger{" +
                "n=" + n +
                '}';
    }
}

