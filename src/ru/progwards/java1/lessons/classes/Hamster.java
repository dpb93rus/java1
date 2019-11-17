package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal{
    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        AnimalKind a = AnimalKind.HAMSTER;
        return a;
    }
    @Override
    public FoodKind getFoodKind() {
        FoodKind b = FoodKind.CORN;
        return b;
    }
    @Override
    public double getFoodCoeff(){
        double c = 0.03;
        return c;
    }
}

