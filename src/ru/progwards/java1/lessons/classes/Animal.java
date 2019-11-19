package ru.progwards.java1.lessons.classes;

public class Animal {
    public Animal(double weight) {
        double w = getWeight();
    }
    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK,
    }

    public AnimalKind getKind() {
        AnimalKind a = AnimalKind.ANIMAL;
        return a;
    }

    enum FoodKind {
        UNKNOWN,
        HAY,
        CORN,
    }

    public FoodKind getFoodKind() {

        FoodKind b = FoodKind.UNKNOWN;
        return b;
    }

    public String toString() {
        return ("I am " + getKind() + ",eat " + getFoodKind() + " " + сalculateFoodWeight());
    }

    public double getWeight() {
        double w = 1.0;
        return w;
    }

    public double getFoodCoeff() {
        double c = 0.02;
        return c;
    }

    public double сalculateFoodWeight() {
        double W = getWeight() * getFoodCoeff();
        return W;
    }

    public static void main(String[] args) {
        Animal A1 = new Animal(12.3);
        System.out.println(A1);
    }
}