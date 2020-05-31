package ru.progwards.java2.lessons.basetypes;

import java.util.Objects;

public class MyInteger implements HashValue{
    Integer myInteger;
    MyInteger(Integer integer) {
        myInteger = integer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInteger myInteger1 = (MyInteger) o;
        return myInteger.equals(myInteger1.myInteger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myInteger);
    }

    @Override
    public int getHash(int absSize) {
        return myInteger%absSize;
    }
}
