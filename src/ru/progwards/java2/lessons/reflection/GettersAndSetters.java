package ru.progwards.java2.lessons.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GettersAndSetters {

    public static void check (String clazz) throws ClassNotFoundException {
        boolean methodExist = false;
        StringBuilder s = new StringBuilder();
        Class a = Class.forName(clazz);
        for (Field f: a.getDeclaredFields()) {
            for (Method m : a.getDeclaredMethods()) {
                if (m.getName().toUpperCase().equals("SET" + f.getName())) {
                    methodExist = true;
                    break;
                }
            }
            if (!methodExist) {
                String nameField = f.getName();
                String n = nameField.substring(0,1).toUpperCase() + nameField.substring(1);
                s.append("public void set" + n + "(" + f.getType().getSimpleName() + " " + f.getName() + ")\n");
            }
            methodExist = false;
        }
        for (Field f: a.getDeclaredFields()) {
            for (Method m : a.getDeclaredMethods()) {
                if (m.getName().toUpperCase().equals("GET" + f.getName())) {
                    methodExist = true;
                    break;
                }
            }
            if (!methodExist) {
                String nameField = f.getName();
                String n = nameField.substring(0,1).toUpperCase() + nameField.substring(1);
                s.append("public " + f.getType() + " get" + n + "()\n");
            }
            methodExist = false;
        }
        System.out.println(s);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        check("ru.progwards.java2.lessons.generics.Fruit");
    }






}
