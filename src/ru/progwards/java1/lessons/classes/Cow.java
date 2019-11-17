package ru.progwards.java1.lessons.classes;

public class Cow extends Animal {
    public Cow(double weight) {
        super(weight);
    }
    @Override
    public AnimalKind getKind() {
        AnimalKind a = AnimalKind.COW;
        return a;
    }
    @Override
    public FoodKind getFoodKind() {
        FoodKind b = FoodKind.HAY;
        return b;
    }
    @Override
    public double getFoodCoeff(){
        double c = 0.05;
        return c;
    }
}
