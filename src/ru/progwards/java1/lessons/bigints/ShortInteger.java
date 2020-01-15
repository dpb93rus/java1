package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ShortInteger extends AbsInteger {
    ShortInteger (short a){
        BigInteger A = new BigInteger(String.valueOf(a));
    }
}
