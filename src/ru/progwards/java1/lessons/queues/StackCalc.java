package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {
    ArrayDeque<Double> A = new ArrayDeque<>();
    public void push(double value) { A.push(value); }
    public double pop() { return A.pop(); }
    public void add() { A.push(A.pop() + A.pop()); }
    public void sub() { double t = A.pop(); A.push(A.pop()-t); }
    public void mul(){ A.push(A.pop() * A.pop()); }
    public void div() { double t = A.pop(); A.push(A.pop()/t); }
 }



