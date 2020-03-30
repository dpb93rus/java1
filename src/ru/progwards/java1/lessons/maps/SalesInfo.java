package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SalesInfo {
    Map<Integer, Record> data = new HashMap();

    public static class Record {
        String fio, item = "";
        int num = 0;
        double sum = 0;

        public Record(String fio, String item, int num, double sum) {
            this.fio = fio;
            this.num = num;
            this.sum = sum;
            this.item = item;
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
                        Record rec = new Record(m[0], m[1], Integer.parseInt(m[2].replaceAll(" ", "")), Double.parseDouble(m[3].replaceAll(" ", "")));
                        data.put(i, rec);
                        i++;
                    } catch (NumberFormatException e) {
                        System.out.println(m[0]+m[1]+m[2]+m[3]);
                    }
                }
            }
        } catch (Throwable e) {
            System.err.println("Произошло необъяснимое и не очень понятное недоразумение");
            throw new Exception();
        }
        return i;
    }


    public Map<String, Double> getGoods() {
        TreeMap <String, Double> D = new TreeMap();
        for (Map.Entry <Integer, Record> temp :data.entrySet()) {
            if (!(D.containsKey(temp.getValue().item))) D.put(temp.getValue().item, temp.getValue().sum);
            else D.put(temp.getValue().item, ((D.get(temp.getValue().item))+temp.getValue().sum));
        }
        return D;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        TreeMap <String, AbstractMap.SimpleEntry<Double, Integer>> D = new TreeMap();
        for (Map.Entry <Integer, Record> temp :data.entrySet()) {
            if (!(D.containsKey(temp.getValue().fio))) D.put(temp.getValue().fio, new AbstractMap.SimpleEntry<Double, Integer>(temp.getValue().sum, temp.getValue().num));
            else D.put(temp.getValue().fio, new AbstractMap.SimpleEntry<Double, Integer>(temp.getValue().sum + D.get(temp.getValue().fio).getKey(), temp.getValue().num+D.get(temp.getValue().fio).getValue())); // D.put(temp.getValue().item, ((D.get(temp.getValue().item))+temp.getValue().sum));
        }
        return D;
    }


    public static void main(String[] args) throws Throwable {
        SalesInfo A = new SalesInfo();
        System.out.println(A.loadOrders("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.test.tokens"));
        System.out.println(A.data);
        System.out.println(A.getGoods());
        System.out.println(A.getCustomers());
    }
}