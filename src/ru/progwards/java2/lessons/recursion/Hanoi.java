//package ru.progwards.java2.lessons.recursion;
//
//import java.util.ArrayDeque;
//import java.util.Collections;
//
//public class Hanoi {
//    int size, pos; boolean show;  ArrayDeque<Integer> tower [] = new ArrayDeque[3];
//    public HanoiTower(int size, int pos) {
//        this.size = size; this.pos = pos; show = false;
//        for (int i = size; i >= 1; i--) tower[pos-1].push(i);
//    }
//
//
//    public void step_move (int from, int to) {
//        if (tower[to-1].peek() > tower[from-1].peek()) tower[to-1].push(tower[from-1].pop());
//        else System.out.println("Недопустимая операция");
//    }
//    static String ring(int num) {
//        String ring;
//        if (num < 10) return  "<00" + num + ">"; if (num < 100) return "<0" + num + ">"; else return "<" + num + ">";
//    }
//    void print() {
//        String stick = "I"; String base = "___________________________\n";
//        ArrayDeque<Integer> for_output [] = Collections.copy(tower);
//
//    }
//    void setTrace(boolean on) {
//        show = on;
//}
