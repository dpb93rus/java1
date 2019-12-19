package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    int weight;
    Food (int weight){
    this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {

    }
}
