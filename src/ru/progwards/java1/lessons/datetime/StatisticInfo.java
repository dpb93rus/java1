package ru.progwards.java1.lessons.datetime;

import java.time.Instant;

public class StatisticInfo {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;
    public Instant start;

    public String toString() {
        return sectionName + "  " + fullTime + "  " +selfTime + "  " +count;
    }


}
