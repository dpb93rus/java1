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
        ArrayList<Integer> A = new ArrayList<>(B);
        ArrayList<Integer> C = new ArrayList<>(B);
        long a = System.nanoTime();
        minSort(A);
        a = System.nanoTime() - a;
        System.out.println("minSort    " + a);
        long b = System.nanoTime();
        mySort(B);
        b = System.nanoTime() - b;
        System.out.println("mySort      "+ b);
        long c = System.nanoTime();
        collSort(C);
        c = System.nanoTime() - c;
        System.out.println("collSort   "+c);
        ArrayList<Long> R = new ArrayList<>(List.of(a,b,c));
        ArrayList<String> S = new ArrayList();
        Collections.sort(R);
        String aa = "minSort";
        String bb = "mySort";
        String cc = "collSort";
        for (Long t: R) {
            if (t.equals(a)) S.add(aa);
            if (t.equals(c)) S.add(cc);
            if (t.equals(b)) S.add(bb);

        }
        ArrayList<String> fakeData= new ArrayList(List.of(cc,aa,bb));
        return fakeData;
    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        for (int n=1; n<70;n++) {
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









