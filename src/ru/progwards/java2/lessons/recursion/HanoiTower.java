package ru.progwards.java2.lessons.recursion;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class HanoiTower {
int size, pos; boolean show;  int[][] tower;
    public HanoiTower(int size, int pos) {
        this.size = size; this.pos = pos; show = false;
         tower = new int[size][3];
         for (int a = 0; a < tower.length; a++) Arrays.fill(tower[a], 0);
        for (int i = 0; i <tower.length; i++) tower[i][pos-1] = tower.length - i;
        }


    public void move (int from, int to) {
        int a = 0;
        int b = 0;
        for (a = 0; ((tower[a][from - 1]!= 0) && (a < tower.length-1)); a++);
        for (b = 0; ((tower[b][to - 1]!= 0) && (b < tower.length-1)); b++);
        tower[b][to - 1] = tower[a][from - 1];
        tower[a][from - 1] = 0;
    }


//    public void move (int from, int to) {
//        int i = tower.length-1;
//        while (i >= 0) {
//            if ((tower[i][from - 1] != 0)
//            for (int j = 0; j < tower.length; j++) {
//                 && (tower[j][to - 1] == 0)) {
//                    if (j == 0 || tower[j - 1][to - 1] > tower[j][to - 1]) {
//                        tower[i][to - 1] = tower[j][from - 1];
//                        tower[j][from - 1] = 0;
//                        return;
//                    }
//
//                }
//            }
//        }
//        System.out.println("Недопустимая операция");
//    }
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
    void setTrace(boolean on) {
        show = on;
    }

    public static void main(String[] args) {
        HanoiTower a = new HanoiTower(5,1);
        a.print();
        a.move(1,2);a.print();a.move(2,1);a.print();
    }
}
