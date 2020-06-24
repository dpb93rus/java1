package ru.progwards.java2.lessons.reflection;

class Person {
    private String name;

    public Person() {
        name = "no name";
    }

    private Person(String name) {
        this.name = name;
    }
}