package ru.progwards.java1.lessons.sets;

import java.util.Comparator;

public class Product {

    private String code;

public Product(String code) {
this.code = code;
}

    @Override
    public String toString() {
        return this.code;
    }

    public String getCode(){
return this.code;
}

    }


