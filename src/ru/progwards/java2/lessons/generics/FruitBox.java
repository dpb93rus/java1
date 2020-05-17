package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;

public class FruitBox <T extends Fruit> extends ArrayList<T> implements Comparable <FruitBox<T>>{
    ArrayList<T> a;
    public FruitBox  () {
        a = new ArrayList<>();
    }
    public void addFruit(T r) {
        if (this.a.isEmpty()|(r.getClass().equals(this.a.get(0).getClass()))) this.a.add(r);
        else throw new UnsupportedOperationException ("UnsupportedOperationException");
    }
    public float getWeight(){
        if (this.a.size() == 0) return 0l;
        return this.a.get(0).weight * a.size();
    }
    public void moveTo(FruitBox b) {
        if ((this.a.isEmpty() || b.isEmpty()) || (b.a.get(0).getClass().equals(this.a.get(0).getClass()))) {
            b.a.addAll(this.a);
            this.a.clear();
        } else throw new UnsupportedOperationException("UnsupportedOperationException");
    }
    @Override
    public int compareTo(FruitBox <T> b) {
        if ((this.a.get(0).weight * this.a.size() == b.a.get(0).weight * b.size())) return 0;
        if ((this.a.get(0).weight * this.a.size() > b.a.get(0).weight * b.size())) return 1;
        return -1;
    }


}

