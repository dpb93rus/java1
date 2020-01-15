package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ByteInteger extends AbsInteger {
//    ByteInteger (byte a){
//        BigInteger A = new BigInteger(String.valueOf(a));

        byte a;
        ByteInteger(byte a) {
            this.a = a;
        }
        @Override
        public String toString() {
            return Byte.toString(a);}
    }

