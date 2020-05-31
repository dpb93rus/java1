package ru.progwards.java2.lessons.basetypes;

import java.util.Objects;

public class MyString implements HashValue{
    String myString;

    MyString(String string) {
        myString = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString1 = (MyString) o;
        return myString.equals(myString1.myString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myString);
    }

    @Override
    public int getHash(int absSize) {
        char[] str = myString.toCharArray();
        int b = 378551;
        int a = 63689;
        int hash = 0;
        for(char t: str) {
            hash = hash * a + t;
            a *= b;
        }
        if (hash < 0) hash = hash-2*hash;
        return hash%absSize;
    }

    public static void main(String[] args) {
        MyString a = new MyString("ssssssssssaass");
        System.out.println(a.getHash(101));
    }
}
