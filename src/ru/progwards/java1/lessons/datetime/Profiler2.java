package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Profiler2 {
        static Map<String, StatisticInfo> data = new TreeMap<>();
        static Stack<Instant> enterTime = new Stack<>();
        static Stack<String> stack = new Stack<>();
        static String lastClosed;
        static String lastOpened;
        static boolean isOpen = false;
        public static class StatisticInfo {
            public String sectionName;                                                             //
            public int fullTime;                                                                   //
            public int selfTime;                                                                   //
            public int count = 0;                                                                      //
            public String Inner = "";                                                                   //
            public String Outer;                                                                   //
            public boolean contInner;
            public boolean contOuter;
            public boolean open;

            @Override
            public String toString() {
                return sectionName+"     "+fullTime+"     "+selfTime+"     "+count;
            }
        }
        public static void enterSection(String name) {
         if (data.containsKey(name)&&data.get(name).open) System.err.println
                 ("Ошибка!!! Вы пытаетесь запустить секцию, которая уже запущена!!!");
         enterTime.push(Instant.now());
         StatisticInfo temp = new StatisticInfo();
         if (!data.containsKey(name)) temp.sectionName = name;
         else temp = data.get(name);
         if (temp.count == 0) { temp.Inner = ""; temp.contInner = false; }
        temp.open = true;
         if (isOpen) temp.Outer = lastOpened; data.get(lastOpened).Inner = name;
        data.put(name, temp);
        stack.push(name);
        lastOpened = name;
        isOpen = true;

    }

        public static void exitSection(String name){
        if (!data.containsKey(name.toString())) {
            System.err.println
                    ("Ошибка!!! Вы пытаетесь закрыть секцию "+name+", которой не существует!!!" +
                            " Проверьте имя или откройте новую секцию если она не создана!!!");
            return;
        }
        if (data.containsKey(name)&&data.get(name).open&&!"".equals(data.get(name).Inner)&&(data.get(data.get(name).Inner)).open) {
            System.err.println("Ошибка!!! Вы пытаетесь закрыть секцию "+name+", внутри которой не закрыта внутренняя секция "+data.get(data.get(name).Inner).sectionName+ "!!!" +
                            " Закройте внутреннюю секцию и попробуйте еще раз!!!");
            return;
        }
        StatisticInfo temp = data.get(name);
        int t = (int) (Duration.between(enterTime.pop(), Instant.now()).toMillis());
        temp.fullTime += t;
        if (temp.contInner) temp.selfTime = temp.fullTime - data.get(stack.pop()).fullTime;
        else if (temp.count == 0)  temp.selfTime = temp.fullTime;
        if (temp.count > 0)  temp.selfTime += t;
        temp.count++;
        temp.open = false;
        data.put(name, temp);
        lastClosed = name;
        isOpen = false;
        }


    public static List<StatisticInfo> getStatisticInfo(){
            List<StatisticInfo> list = new ArrayList<>();
            for (StatisticInfo temp: data.values()) {
                list.add(temp);
            }
    return list;
    }

    public static void main(String[] args) {
            enterSection("1");

        enterSection("2");
        for (int n = 1; n < 2000000000; n++) {
            int b = (n + 11)/n * (n+n)/5;
        }
        exitSection("2");
            for (int n = 1; n < 2000000000; n++) {
                int a = (n + 11)/n * (n+n)/5;
            }
            exitSection("1");
        enterSection("1");
        for (int n = 1; n < 2000000000; n++) {
            int b = (n + 11)/n * (n+n)/5;
        }
        exitSection("1");


        System.out.println(getStatisticInfo());
    }



}
