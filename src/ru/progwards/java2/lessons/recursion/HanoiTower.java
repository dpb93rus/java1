package ru.progwards.java2.lessons.recursion;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class HanoiTower {
int size, pos; static boolean show;  int[][] tower; int levelIteration;
    public HanoiTower(int size, int pos) {
        if (size < 1) {
            System.err.println("Башня неизмеримо мала либо расположена в мнимом подпространстве, мнимой размерности, фантомной модальности");
            return;
        }
        this.size = size; this.pos = pos; levelIteration = size;
         tower = new int[size][3];
         for (int a = 0; a < tower.length; a++) Arrays.fill(tower[a], 0);
        for (int i = 0; i <tower.length; i++) tower[i][pos-1] = tower.length - i;
    }
    public HanoiTower() {
        size = 5; pos = 1; levelIteration = size;
        tower = new int[size][3];
        for (int a = 0; a < tower.length; a++) Arrays.fill(tower[a], 0);
        for (int i = 0; i <tower.length; i++) tower[i][pos-1] = tower.length - i;
    }

    static String ring(int num) {
        String ring;
        if (num < 10) return  " <00" + num + "> "; if (num < 100) return "<0" + num + ">"; else return "<" + num + ">";
    }
    void print() {
        String stick = "I";
        String base = "========================\n";
        for (int a = tower.length-1; a >= 0; a--) {
            for (int b = 0; b < tower[a].length; b++) {
                if (tower[a][b] == 0) System.out.print("   I   ");
                else System.out.print(ring(tower[a][b]));
            }
            System.out.println("");
        }
        System.out.println(base);
    }
    static void setTrace(boolean on) {
        if (on) show = true;
    }
    public boolean moveStep (int from, int to) {
        int a = 0; int b = 0;
        for (a = 0; a < tower.length; a++) if (tower[a][from - 1] == 0) break;
        for (b = 0; ((tower[b][to - 1]!= 0) && (b < tower.length+1)); b++);
//        if ((b != 0) && (a == 0 || b > 4 || tower[b][to - 1] < tower[b-1][to - 1])) {
//            System.err.println("Недопустимая операция");
//            return false;
//        }
        tower[b][to - 1] = tower[a-1][from - 1];
        tower[a-1][from - 1] = 0;
        if (show) this.print();
        return true;
    }


    public void move (int from, int to) {
        if (levelIteration == 1) {
            this.moveStep(from,to);
            return;
        }

        this.move(from,6-from-to,levelIteration-1); this.moveStep(from,to); this.move(6-from-to,to, levelIteration-1);

    }
    public void move (int from, int to, int levelIteration) {
        if (levelIteration == 1) {
            this.moveStep(from,to);
            return;
        }

        this.move(from,6-from-to,levelIteration-1); this.moveStep(from,to); this.move(6-from-to,to, levelIteration-1);
    }



//    public static void main(String[] args) {
//        HanoiTower a = new HanoiTower(9,1);
//        setTrace(true);
//        a.print();
//        a.move(1,3);
//        a.print();
//
//    }
}
