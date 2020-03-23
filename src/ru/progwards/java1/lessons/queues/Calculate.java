package ru.progwards.java1.lessons.queues;

        import java.util.ArrayDeque;
        import java.util.Collection;

public class Calculate {

    public static double calculation1() {
       return  2.2*(3+12.1);
    }

    public static double calculation2() {
        return (737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2));
    }
    int sumLastAndFirst(ArrayDeque<Integer> deque){
        if (deque.isEmpty()) return 0;
        return deque.pollFirst() + deque.pollLast();
    }
    public static void main(String[] args) {
    StackCalc G = new StackCalc();

    }
}