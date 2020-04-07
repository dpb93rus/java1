package ru.progwards.java1.lessons.datetime;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;


public class Insurance {

    public static enum FormatStyle {SHORT, LONG, FULL}
    private String val;
    private ZonedDateTime start;
    private Duration duration;
    private boolean lastRes;

    public Insurance(ZonedDateTime start){ this.start = start;  }

    public Insurance(String strStart, FormatStyle style) {

        if (style == FormatStyle.SHORT) {
            LocalDate D = LocalDate.parse(strStart, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalTime T = LocalTime.of(0,0) ;
            start = ZonedDateTime.of(D,T, ZoneId.systemDefault());

        }
        if (style == FormatStyle.LONG) {
            LocalDateTime D = LocalDateTime.parse(strStart, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            start = ZonedDateTime.of(D, ZoneId.systemDefault());
        }
        if (style == FormatStyle.FULL) {
            start = ZonedDateTime.parse(strStart, DateTimeFormatter.ISO_ZONED_DATE_TIME);
        }
    }

    public void setDuration (Duration duration) {this.duration = duration;}

    public void setDuration(ZonedDateTime expiration){
        duration = Duration.between(start, expiration);
    }

    public void setDuration(int months, int days, int hours){
        duration = Duration.between(start, start.plusMonths(months).plusDays(days).plusHours(hours));
    }
    public void setDuration(String strDuration, FormatStyle style) {
        if (style == FormatStyle.SHORT) {
            duration = Duration.ofMillis(Long.parseLong(strDuration));
        }
        if (style == FormatStyle.LONG) {
            LocalDateTime t = LocalDateTime.parse(strDuration, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            duration = Duration.between(LocalDateTime.parse("0000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME), t);
        }
        if (style == FormatStyle.FULL) {
            duration = Duration.parse(strDuration);
        }
    }
    public boolean checkValid (ZonedDateTime dateTime) {
        if (duration==null) return dateTime.isAfter(start);
        return !(dateTime.isAfter(start.plus(duration))|(dateTime.isBefore(start)));
    }
    public String toString(){
        if (this.checkValid(Instant.now().atZone(ZoneId.systemDefault()))) return "Insurance issued on " + start + " is valid";
        return "Insurance issued on " + start + " is not valid";
    }

    public static void main(String[] args) {
        Insurance A = new Insurance( ZonedDateTime.now().minus(1, ChronoUnit.MINUTES).toString(), FormatStyle.FULL);
        A.setDuration(Duration.ofDays(75L));
        System.out.println(A.toString());
        Insurance B = new Insurance( LocalDateTime.now().plus(1L, ChronoUnit.DAYS).toString(), FormatStyle.LONG);
        B.setDuration(Duration.ofDays(150L));
        System.out.println(B.toString());
    }
}
