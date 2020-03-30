package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SalesInfo2 {
    Map<String, Record> data = new HashMap();

    public static class Record {
        String fio, item = "";
        int num = 0;
        double sum = 0;

        public Record(String fio, int num, double sum) {
            this.fio = fio;
            this.num = num;
            this.sum = sum;
        }
    }

    public int loadOrders(String fileName) throws Throwable {
//        if (!data.isEmpty()) data.clear();
        int i = 0;
        try (FileReader reader = new FileReader(fileName);
             Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] m = s.split(",");
                if (m.length == 4) {
                    try {
                        Record rec = new Record(m[0], Integer.parseInt(m[2].replaceAll(" ", "")), Double.parseDouble(m[3].replaceAll(" ", "")));
                        data.put(m[1], rec);
                        i++;
                    } catch (NumberFormatException e) {
                        System.out.println(m[0]+m[1]+m[2]+m[3]);
                    }
                }
            }
        } catch (Throwable e) {
            System.err.println("Произошло необъяснимое и не очень понятное недоразумение");
        }
        return i;
    }


    public Map<String, Double> getGoods() {
        TreeMap <String, Double> D = new TreeMap();
        for (Map.Entry <String, Record> temp :data.entrySet()) {
            if (!(D.containsKey(temp.getKey()))) D.put(temp.getKey(), temp.getValue().sum);
            else D.put(temp.getKey(), ((D.get(temp.getKey()))+temp.getValue().sum));
        }
        return D;
    }
//
//    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
//
//    }

    public static void main(String[] args) throws Throwable {
        SalesInfo2 A = new SalesInfo2();
        System.out.println(A.loadOrders("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.test.tokens"));
        System.out.println(A.data);
        System.out.println(A.getGoods());
    }
}