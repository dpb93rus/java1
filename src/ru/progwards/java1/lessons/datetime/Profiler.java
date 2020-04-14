package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Profiler {
    static Map<String, StatisticInfo> data = new TreeMap<>();
    static Stack <Map.Entry<String, StatisticInfo>> stack = new Stack<>();
    public static void enterSection(String name) {
        StatisticInfo temp = new StatisticInfo();
        if (temp.count == 0) temp.sectionName = name;
        else temp = data.get(name);
        temp.start = Instant.now();
        Map.Entry <String, StatisticInfo> t =  new AbstractMap.SimpleEntry<String, StatisticInfo> (name, temp);
        stack.push(t);
    }
    public static void exitSection(String name) {
        StatisticInfo temp2 = new StatisticInfo();
        StatisticInfo temp = stack.pop().getValue();
        if (!data.containsKey(name)) temp2 = data.get(name);
        int t = (int) (Duration.between(temp.start, Instant.now()).toMillis());
        temp2.fullTime += t;
        temp2.selfTime += t;
        temp2.count++;
        data.put(name, temp);
        if (!stack.isEmpty()) {
            temp = stack.pop().getValue();
            temp.selfTime -= t;
            stack.push(new AbstractMap.SimpleEntry<String, StatisticInfo>(temp.sectionName, temp));
        }
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