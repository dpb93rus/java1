package ru.progwards.dpb;

public class Convert {
    static int addAsStrings(int n1, int n2) {
        String n3 = ((String) n1 + (String) n2);
        int i = Integer.parseInt(n3);
        return i;
    }

    public static void main(String[] args) {
        addAsStrings (2,7);
        System.out.println(addAsStrings (2,7));
    }
}
