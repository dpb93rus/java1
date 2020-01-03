package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

public class Food implements CompareWeight {
    int weight;
    Food (int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return weight == food.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
return null;
    }
}
