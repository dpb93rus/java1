package ru.progwards.java2.lessons.anno;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface First {
    String value() default "Hello, my first annotation";
    String name();
}
