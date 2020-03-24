package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsageFrequency {
    StringBuffer D = new StringBuffer(""); String C;// Переменные класса принимающие строку
        public static String[] sep(StringBuffer i) {
            StringBuilder t = new StringBuilder();
            String o[] = new String[1000000];
            int n1 = 0;
            for (int n = 0; n < i.length(); n++) {
                if (Character.isLetter(i.charAt(n))) t.append(i.charAt(n));
                if (!Character.isLetter(i.charAt(n))) {
                    if (t.length() > 0) {
                        o[n1] = t.toString();
                        n1++;
                        t = new StringBuilder();
                    }
                    i.deleteCharAt(0);
                }
            }
            return o;
        }
    public void processFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            for (int c; (c = reader.read()) != -1; ) D.append((char)c);
            C = new String(D);
        } catch (Throwable e) {
            System.err.println("Произошло непонятное недоразумение");
        }
    }

        public Map<Character, Integer> getLetters() {
            Map<Character, Integer> map = new HashMap<>();
            char [] a = C.toCharArray();
            for (char t:a) {
                if  (Character.isLetter(t)) {
                    Integer temp = map.get(t);
                    if (temp == null) {
                        map.put(t, 1);
                    } else {
                        map.put(t, (temp + 1));
                    }
                }
            }
            return map;

    }
    public Map<String, Integer> getWords() {
        Map<String, Integer> map= new HashMap<>();
        String[] s = sep(D);
        for (String t:s){
            if ("".equals(t)) break;
            Integer temp = map.get(t);
            if (temp == null) {
                map.put(t, 1);
            } else {
                map.put(t, (temp + 1));
            }
        }
        return map;
    }
    public static void main(String[] args) {
        UsageFrequency Z = new UsageFrequency();
            Z.processFile("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.test.tokens");

        char xxx = 'h';
        System.out.println(Z.getLetters().get('v'));
        System.out.println(Z.getWords().get("he"));
    }



}
