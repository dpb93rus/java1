package ru.progwards.java1.lessons.interfaces;

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
    public static void main(String[] args) {
        Cow A1 = new Cow(12.3);
        System.out.println(A1);
    }
}
