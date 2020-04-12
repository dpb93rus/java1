package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Pr {
    static Map<String, StatisticInfo> data = new TreeMap<>();
    static Stack <Map.Entry<String, StatisticInfo>> stack = new Stack<>();
    static boolean opened; static String lastOpened;
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
        if (data.containsKey(name)&&!stack.isEmpty()&&stack.peek().getValue().sectionName.equals(name)) System.err.println ("Ошибка!!! Вы пытаетесь запустить секцию, которая уже запущена!!!");
        StatisticInfo temp = new StatisticInfo();
        if (data.containsKey(name)) temp = data.get(name);
        if (temp.count == 0) temp.sectionName = name;
        temp.start = Instant.now();
        Map.Entry <String, StatisticInfo> t =  new AbstractMap.SimpleEntry<String, StatisticInfo> (name, temp);
        if (opened) {
            Map.Entry<String, StatisticInfo> t1 = new AbstractMap.SimpleEntry<>(lastOpened, data.get(lastOpened));
            StatisticInfo t2 = t1.getValue();
            t2.Inner = name;
            t1.setValue(t2);
            data.put(lastOpened, t2);
        }
        stack.push(t);
        data.put(name,temp);
        opened = true;
        lastOpened = name;
    }

    public static void exitSection(String name){
        if (!name.equals(stack.peek().getKey())) {
            System.err.println("Неверное имя закрываемой секции либо незакрыта внутренняя секция!!!");
        }
        StatisticInfo temp = stack.pop().getValue();
        int t = (int) (Duration.between(temp.start, Instant.now()).toMillis());
        temp.fullTime += t;
        if ( data.containsKey(temp.Inner)) { temp.selfTime = temp.fullTime - data.get(temp.Inner).fullTime; temp.Inner = ""; }

        temp.count++;
        data.put(name,temp);
        opened = false;
    }


    public static List<StatisticInfo> getStatisticInfo(){
        List<StatisticInfo> list = new ArrayList<>();
        for (StatisticInfo temp: data.values()) {
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        enterSection("1");for (int n = 1; n < 2000000000; n++) {int a = (n + 11)/n * (n+n)/5; }
        enterSection("2");for (int n = 1; n < 2000000000; n++) {int a = (n + 11)/n * (n+n)/5; }exitSection("2");
        exitSection("1");
        System.out.println(getStatisticInfo());
    }



}
