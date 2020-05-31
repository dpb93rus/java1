package ru.progwards.java2.lessons.basetypes;
import java.util.Arrays;

public class MyMath {

    int N = 0;
    private static boolean[] sieve;

    public MyMath(int N) {
        this.N = N;
        sieve = new boolean[N];
        Arrays.fill(sieve, true);
        sift();
    }

    private void sift() {
        int i = 2;
        int j = 2;
        for (i = 2; i < N; i++) {
            for (j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    sieve[i] = false;
                    break;
                }
            }
        }
    }

    public static boolean isSimple(int n) {
        MyMath E1 = new MyMath(n + n / 7);
        E1.sift();
        return sieve[n];
    }

    public static int doubleHighSimple(int n) {
        for (int i = 1; i <= n / 2; i++) {
            boolean r = isSimple(2 * n + i);
            if (r) return 2 * n + i;
        }
        return n * 2 + 1;
    }

    public static int halfHighSimple(int n) {
        for (int i = 1; i <= n / 5; i++) {
            boolean r = isSimple(n / 2 + i);
            if (r) return n / 2 + i;
        }
        return n / 2 + 1;
    }

    public static int deepHash(int preHash,int absSize) {
        char[] str = (preHash*absSize + "" + absSize+ preHash + (absSize+1)).toCharArray();
        int b = 378551;
        int a = 63689;
        int hash = 0;
        for(char t: str) {
            hash = hash * a + t;
            a *= b;
        }
        if (hash < 0) hash = hash-2*hash;
        return hash%absSize;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> a = new ArrayList<>();
//        for (int i = 101; i < 419; i++) {
//            a.add(deepHash(i, 101));
//        }
//        Collections.sort(a);
//        System.out.println(a);
    }
}

