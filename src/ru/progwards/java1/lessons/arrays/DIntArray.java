package ru.progwards.java1.lessons.arrays;
        import java.util.Arrays;
public class DIntArray {
    private int a[] = {};

    DIntArray () {
    }
    public void add(int num){
        int [] b = new int [a.length+1];
        System.arraycopy(a , 0 , b , 0, (a.length));
        b[b.length-1] = num;
        a = b;
    }
    public void atInsert(int pos, int num) {
        int [] b = new int [a.length+1];
        System.arraycopy(a , 0 , b , 0, pos);
        System.arraycopy(a , pos , b , pos+1, (b.length-pos-1));
        b[pos] = num;
        a = b;
    }
    public void atDelete(int pos) {
        int [] b = new int [a.length-1];
        System.arraycopy(a , 0 , b , 0, pos);
        System.arraycopy(a , pos+1 , b , pos, (b.length-pos));
        a = b;
    }
    public int at(int pos) {
        System.out.println(a[pos]);
        return a[pos] ;
    }
    public String toString() {
        System.out.println(Arrays.toString(a));
        return null;
    }
        public static void main(String[] args) {
            DIntArray a = new DIntArray();
           // a.add (19);
           // a.add (-3);
           // a.add (-49);
           // a.add (-94);
           // a.add (-25);
           // a.add (31);
           // a.add (-40);
           // a.add (59);
           // a.add (-31);
           // a.add (35);
           // a.add (6);
           // a.add (-7);
           // a.add (-54);
           // a.add (-46);
            //a.add (24);
            //a.add (40);
           // a.atInsert(2,10000);
            //a.atDelete (3);
            //a.at(0);
            //a.toString();
    }

}
