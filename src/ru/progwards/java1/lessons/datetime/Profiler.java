package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Profiler {
        static Map<String, StatisticInfo> data = new TreeMap<>();
        static Queue <Map.Entry<String, StatisticInfo>> stack = new ArrayDeque<>();
        public static class StatisticInfo {
            public String sectionName;                                                             //
            public int fullTime;                                                                   //
            public int selfTime;                                                                   //
            public int count = 0;
            public Instant start;
            public String Inner;
            @Override
            public String toString() {
                return sectionName+"     "+fullTime+"     "+selfTime+"     "+count;
            }
        }
        public static void enterSection(String name) {
         if (data.containsKey(name)&&stack.peek().getValue().sectionName.equals(name)) System.err.println ("Ошибка!!! Вы пытаетесь запустить секцию, которая уже запущена!!!");
         StatisticInfo temp = new StatisticInfo();
         if (temp.count == 0) temp.sectionName = name;
         else temp = data.get(name);
         temp.start = Instant.now();
            Map.Entry <String, StatisticInfo> t =  new AbstractMap.SimpleEntry<String, StatisticInfo> (name, temp);
            if (!stack.isEmpty()) stack.peek().getValue().Inner =name;
            stack.offer(t);
    }

        public static void exitSection(String name){
        if (!name.equals(stack.peek().getKey())) {
            System.err.println("Неверное имя закрываемой секции либо незакрыта внутренняя секция!!!");
            return;
        }
        StatisticInfo temp = stack.poll().getValue();
        int t = (int) (Duration.between(temp.start, Instant.now()).toMillis());
        temp.fullTime += t;
        if (temp.count == 0) temp.selfTime = temp.fullTime;
        else temp.selfTime +=t;
        if (!"".equals(temp.Inner)) {
            temp.selfTime = temp.fullTime - stack.peek().getValue().fullTime;
            temp.Inner = "";
        }
        temp.count++;
        data.put(name,temp);
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
