package ru.progwards.java1.lessons.sets;

import java.util.Comparator;

public class Product implements Comparable<Product>{

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


    @Override
    public int compareTo(Product o) {
        if (this.getCode().equals(o.getCode())) return 0;
        return 1;
    }
}


