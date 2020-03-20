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
        ArrayList<Integer> A = new ArrayList<>();
        A.add(23);
        A.add(2);
        A.add(16);
        A.add(87);
        A.add(54);
        A.add(0);
        A.add(-23);
        A.add(-73);

        long a = System.currentTimeMillis();
        minSort(A);
        a = System.currentTimeMillis() - a;
        long b = System.currentTimeMillis();
        mySort(A);
        b = System.currentTimeMillis() - a;
        long c = System.currentTimeMillis();
        collSort(A);
        c = System.currentTimeMillis() - a;
        ArrayList<Long> R = new ArrayList(List.of(a,b,c));
        ArrayList<String> S = new ArrayList();
        Collections.sort(R);
        String aa = "minSort";
        String bb = "mySort";
        String cc = "collSort";
        for (Long t: R) {
            if (t.compareTo(b)==0) {S.add(bb); continue;}
            if (t.compareTo(c)==0) {S.add(cc); continue;}
            if (t.compareTo(a)==0) {S.add(aa); continue;}


        }

        return S;
    }


    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(23);
        A.add(2);
        A.add(16);
        A.add(87);
        A.add(54);
        A.add(0);
        A.add(-23);
        A.add(-73);
        System.out.println(A);
        collSort(A);
        System.out.println(A);
        System.out.println(compareSort());
    }
}









