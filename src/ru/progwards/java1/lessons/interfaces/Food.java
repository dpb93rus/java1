package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

public class Food implements CompareWeight {
    private int weight;
    Food (int weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }


//    public boolean eZqualsZ(Object o) {




    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        double weight1 = getWeight();
        double weight2 = smthHasWeigt.getWeight();
        if (weight1 == weight2) return CompareResult.EQUAL;
        if (weight1 < weight2) return CompareResult.LESS;
        return CompareResult.GREATER;
    }
}
