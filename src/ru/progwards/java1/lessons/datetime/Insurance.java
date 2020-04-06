package ru.progwards.java1.lessons.datetime;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Insurance {

    public static enum FormatStyle {SHORT, LONG, FULL}
    private String val;
    private ZonedDateTime start;
    private Duration duration;
    private boolean lastRes;

    public Insurance(ZonedDateTime start){ this.start = start; }

    public Insurance(String strStart, FormatStyle style) {

        if (style == FormatStyle.SHORT) {
            DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate D = LocalDate.parse(strStart, form);
            LocalTime T = LocalTime.of(0,0);
            start = ZonedDateTime.of(D,T, ZoneId.systemDefault());

        }
        if (style == FormatStyle.LONG) {
            DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
            LocalDateTime D = LocalDateTime.parse(strStart, form);
            start = ZonedDateTime.of(D, ZoneId.systemDefault());
        }
        if (style == FormatStyle.FULL) {
            DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss V");
            start = ZonedDateTime.parse(strStart, form);
        }
    }



    public void setDuration (Duration duration) {this.duration = duration;}

    public void setDuration(ZonedDateTime expiration){
        duration = Duration.between(start,expiration);
    }

    public void setDuration(int months, int days, int hours){
        duration = Duration.between(start,start.plusMonths(months).plusDays(days).plusHours(hours));
    }
    public void setDuration(String strDuration, FormatStyle style) {
        if (style == FormatStyle.SHORT) {
            duration = Duration.ofMillis(Long.parseLong(strDuration));
        }
        if (style == FormatStyle.LONG) {
            DateTimeFormatter form = DateTimeFormatter.ofPattern("ISO_LOCAL_DATE_TIME");
            LocalDateTime t = LocalDateTime.parse(strDuration, form);
            duration = Duration.between(LocalDateTime.parse("0000-00-00T00:00:00", form),t);
        }
        if (style == FormatStyle.FULL) {
            duration = Duration.parse(strDuration);
        }
    }
    public boolean checkValid (ZonedDateTime dateTime) {
        if (dateTime.isAfter(start.plus(duration))) { lastRes = false;  return false;}
        lastRes = true; return true;
    }

    public String toString(){
        if (lastRes) return "Insurance issued on " + start + " is not valid";
        return "Insurance issued on " + start + " is valid";
    }

    public static void main(String[] args) {
        Insurance A = new Insurance("0000-00-00T00:00:00", FormatStyle.SHORT);
    }
}
