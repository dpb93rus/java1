package ru.progwards.dpb;
import java.math.BigDecimal;
import java.util.Objects;

public class Rectangle3 {
    Rectangle3(BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
    }

    public BigDecimal a;
    public BigDecimal b;

    public BigDecimal area() {
        return a.multiply(b);
    }

    boolean rectCompare(Rectangle3 r1, Rectangle3 r2) {
        if (((r1.a).multiply(r1.b)).equals((r2.a).multiply(r2.b)))
            return true;
        return false;
    }}

