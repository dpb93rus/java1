package ru.progwards.java1.lessons.io2;


import java.io.IOException;

public class PhoneNumber {
    public static class WrongNumber extends RuntimeException {
    public WrongNumber () {
        super("Wrong Format Phone");
    }
    @Override
        public String getMessage() {
        return super.getMessage();
    }
    }
    public static String format(String phone)  {
         if (phone.isEmpty()) {
             throw new WrongNumber();
         }


        StringBuffer s = new StringBuffer();   // Create StringBuffer s
        char[] c = phone.toCharArray();       // Create Array char
        int l = c.length;                      // l  -   length of Array
        for (int n = 0; n < l; n++) {
            if (Character.isDigit(c[n])) s.append(c[n]);
        }
     if ((s.length()<10) | (s.length()>11)) {
         throw new WrongNumber();
     }

        if ((s.length() == 11)) s.delete(0, 1);
        s.insert(0, "+7"); s.insert(2, "("); s.insert(6, ")"); s.insert(10, "-");
        return s.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(format("89128-435-3"));
        } catch (WrongNumber a) {
            System.err.println(a.getMessage());
        }
    }
}

