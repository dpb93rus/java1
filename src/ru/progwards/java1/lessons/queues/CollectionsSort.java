package ru.progwards.java1.lessons.queues;

        import java.util.*;

public class CollectionsSort {

    public static void mySort(Collection<Integer> data) {
        List<Integer> a = new ArrayList<>(data);
         int j = 0; int t = 0;
        for (int i = 0, k = a.size(); i < k; i++) {
            for (j = i+1; j < k; j++){
                if (a.get(i) > a.get(j)) {
                    t = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, t);
                }
            }
        }
        data.clear();
        data.addAll(a);
    }

    public static void minSort (Collection < Integer > data) {
        List<Integer> a = new ArrayList<>();
        while (data.size() != 0) {
            a.add(Collections.min(data));
            data.remove(Collections.min(data));
        }
        data.clear();
        data.addAll(a);
    }


    static void collSort (Collection < Integer > data) {
        List<Integer> a = new ArrayList<>(data);
        Collections.sort(a);
        data.clear();
        data.addAll(a);
    }

    public static Collection<String> compareSort () {
        ArrayList<Integer> B = new ArrayList<>();
        for (int n=0; n<70;n++) {
            B.add(23 + 3 * n - n * n);
            B.add(2+ 3 * n - n * n);
            B.add(16+ 3 * n - n * n);
            B.add(87+ 3 * n - n * n);
            B.add(54+ 3 * n - n * n);
            B.add(0+ 3 * n - n * n);
            B.add(-23+ 3 * n - n * n);
            B.add(-73+ 3 * n - n * n);
        }

        long a = System.nanoTime();
        minSort(B);
        a = System.nanoTime() - a;
        System.out.println(a);
        long b = System.nanoTime();
        mySort(B);
        b = System.nanoTime() - b;
        System.out.println(b);
        long c = System.nanoTime();
        collSort(B);
        c = System.nanoTime() - c;
        System.out.println(c);
        ArrayList<Long> R = new ArrayList<>(List.of(a,b,c));
        ArrayList<String> S = new ArrayList();
        Collections.sort(R);
        String aa = "minSort";
        String bb = "mySort";
        String cc = "collSort";
        for (Long t: R) {
            if (t.equals(a)&t.equals(b)==false&t.equals(c)==false) S.add(aa);
            if (t.equals(c)&t.equals(a)==false&t.equals(b)==false) S.add(cc);
            if (t.equals(b)&t.equals(a)==false&t.equals(c)==false) S.add(bb);

        }

        return S;
    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        for (int n=0; n<70;n++) {
            A.add(23 + 3 * n - n * n);
            A.add(2+ 3 * n - n * n);
            A.add(16+ 3 * n - n * n);
            A.add(87+ 3 * n - n * n);
            A.add(54+ 3 * n - n * n);
            A.add(0+ 3 * n - n * n);
            A.add(-23+ 3 * n - n * n);
            A.add(-73+ 3 * n - n * n);
        }
        System.out.println(A);
        mySort(A);
        System.out.println(A);
        System.out.println(compareSort());
    }
}









