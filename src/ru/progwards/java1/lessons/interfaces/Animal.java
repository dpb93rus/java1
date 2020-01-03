package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare {
    public Animal(double weight) {
        double w = getWeight();
    }
    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    public AnimalKind getKind() {
        AnimalKind a = AnimalKind.ANIMAL;
        return a;
    }

    enum FoodKind {
        UNKNOWN,
        HAY,
        CORN
    }

    public FoodKind getFoodKind() {

        FoodKind b = FoodKind.UNKNOWN;
        return b;
    }

    public String toString() {
        return ("I am " + getKind() + ",eat " + getFoodKind());
    }
    public String toStringFull() {
        String s = ("");
        System.out.println("I am " + getKind() + ",eat " + getFoodKind() + " " + calculateFoodWeight());
        return s;
}

    public double getWeight() {
        double w = 1.0;
        return w;
    }

    public double getFoodCoeff() {
        double c = 0.02;
        return c;
    }

    public double calculateFoodWeight() {
        double W = getWeight() * getFoodCoeff();
        return W;
    }
    @Override
     public boolean equals(Object anObject){
        if (this.getClass() != anObject.getClass())
            return false;
        if ((this.getWeight()) == ((Animal)anObject).getWeight()) {
            return true;
        }
        else {return  false;}
        }
    public double getFood1kgPrice() {
        switch (getFoodKind()) {
            case HAY: return 20;
            case CORN: return 50;
            default: return 0;
        }
    }
    public double getFoodPrice(){
        return calculateFoodWeight() * getFood1kgPrice();
    }
    public int compareFoodPrice(Animal animal){
        return Double.compare (this.getFoodPrice(), animal.getFoodPrice());
    }


    public static void main(String[] args) {
        Animal A1 = new Animal(12.3);
        System.out.println(A1);
        A1.toStringFull();
    }
}