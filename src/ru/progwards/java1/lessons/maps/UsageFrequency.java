package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsageFrequency {
    StringBuffer D = new StringBuffer(""); String C;// Переменные класса принимающие строку
    public void processFile(String fileName) throws Exception {
        try {
            FileReader reader = new FileReader(fileName);
            for (int c; (c = reader.read()) != -1; ) D.append(c);
            C = new String(D);
        } catch (Throwable e) {
            throw new Exception();
        }
    }

        public Map<Character, Integer> getLetters() {
            Map<Character, Integer> map = new HashMap<>();
            char [] a = C.toCharArray();
            for (char t:a) {
                if  (Character.isLetter(t)) {
                    Integer temp = map.get(t);
                    if (temp != null)  map.put(t, (temp + 1));
                }
            }
            return map;

    }
    public Map<String, Integer> getWords() {
        Map<String, Integer> map= new HashMap<>();
        String[] s = C.split(".,!? @");
        for (String t:s){
            map.put(t, (map.get(t)) + 1);
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        UsageFrequency Z = new UsageFrequency();
        Z.processFile("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.test.tokens");
        System.out.println(Z.getLetters());
        System.out.println(Z.getWords());
    }



}
