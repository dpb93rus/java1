//package ru.progwards.java2.lessons.reflection;
//import java.lang.reflect.*;
//public class TestRef {
//
//    void setName(Person person, String name) {
//        Class<Person> clazz = Person.class;
//        Field field = null;
//        try {
//            field = clazz.getDeclaredField(name);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        assert field != null;
//        field.setAccessible(true);
//        try {
//            field.set(person, "name");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    Person callConstructor(String name) {
//        Class<Person> clazz = Person.class;
//        Constructor<Person> personConstructor = clazz.getDeclaredConstructor()
//    }
//
//    public static void main(String[] args) {
//        Person person = new Person("I");
//        String nam = "name";
//        TestRef a = new TestRef();
//            a.setName(person, nam);
//        System.out.println(person.getName());
//
//
//    }
//
//}
