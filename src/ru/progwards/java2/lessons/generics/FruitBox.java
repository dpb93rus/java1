package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;

public class FruitBox <T extends Fruit> extends ArrayList<T> implements Comparable <FruitBox<T>>{

    public void addFruit(T r) {
        if (this.isEmpty()|(r.getClass().equals(this.get(0).getClass()))) this.add(r);
        else throw new UnsupportedOperationException ("UnsupportedOperationException");
    }
    public float getWeight(){
        if (this.size() == 0) return 0l;
        return this.get(0).weight * this.size();
    }
    public void moveTo(FruitBox b) {
        if ((this.isEmpty() || b.isEmpty()) || (b.get(0).getClass().equals(this.get(0).getClass()))) {
            b.addAll(this);
            this.clear();
        } else throw new UnsupportedOperationException("UnsupportedOperationException");
    }
    @Override
    public int compareTo(FruitBox <T> b) {
        if ((this.get(0).weight * this.size() == b.get(0).weight * b.size())) return 0;
        if ((this.get(0).weight * this.size() > b.get(0).weight * b.size())) return 1;
        return -1;
    }


}

