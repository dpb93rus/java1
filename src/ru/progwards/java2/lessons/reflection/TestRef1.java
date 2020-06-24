//package ru.progwards.java2.lessons.reflection;
//
//import java.lang.reflect.Field;
//
//public class TestRef1 {
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
//    public static void main(String[] args) {
//        Person person = new Person("I");
//        String nam = "name";
//        TestRef1 a = new TestRef1();
//            a.setName(person, nam);
//        System.out.println(person.getName());
//
//
//    }
//
//}
