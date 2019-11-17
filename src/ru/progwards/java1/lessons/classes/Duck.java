package ru.progwards.java1.lessons.classes;

public class Duck extends Animal {
    public Duck(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        AnimalKind a = AnimalKind.DUCK;
        return a;
    }
    @Override
    public FoodKind getFoodKind() {
        FoodKind b = FoodKind.CORN;
        return b;
    }
    @Override
    public double getFoodCoeff(){
        double c = 0.04;
        return c;
    }
}

