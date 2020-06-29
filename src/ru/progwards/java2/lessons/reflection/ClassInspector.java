package ru.progwards.java2.lessons.reflection;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;

public class ClassInspector {
    public static void inspect(String pathFile, String clazz) throws ClassNotFoundException, IOException {
        Class a = Class.forName(clazz);
        StringBuilder s = new StringBuilder();
        s.append(Modifier.toString(a.getModifiers())+" ").append("class ").append(a.getSimpleName()).append(" {\n");

        for (Field t: a.getDeclaredFields()) {
            s.append("    ");
            if (!Modifier.toString(t.getModifiers()).equals("")) s.append(Modifier.toString(t.getModifiers())+" ");
            s.append(t.getType()).append(" " + t.getName() + ";\n");
        }
        for (Constructor t: a.getDeclaredConstructors()) {
            s.append("    ");
            s.append(Modifier.toString(t.getModifiers())).append(" " + a.getSimpleName() + "(");
            for (Parameter n: t.getParameters()) {
                s.append(n.getType()).append(" "+n.getName()).append(", ");
            }
            if (t.getParameters().length > 0) s.delete(s.length()-2, s.length());
            s.append(") {}\n");
        }
        for (Method t: a.getDeclaredMethods()) {
            s.append("    ");
            if (!Modifier.toString(t.getModifiers()).equals("")) s.append(Modifier.toString(t.getModifiers())+" ");
            s.append(t.getReturnType().getSimpleName()+" ");
            s.append(t.getName() + "(");
            for (Parameter n: t.getParameters()) {
                s.append(n.getType()).append(" "+n.getName()).append(", ");
            }
            if (t.getParameters().length > 0) s.delete(s.length()-2, s.length());
            s.append(") {}\n");
        }
        s.append("}");
        try (FileWriter f = new FileWriter(pathFile +"\\" +a.getSimpleName()+".txt")) {
            f.write(s.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        inspect("C:\\Users\\Дмитрий\\Desktop","ru.progwards.java2.lessons.generics.FruitBox");
    }


}
