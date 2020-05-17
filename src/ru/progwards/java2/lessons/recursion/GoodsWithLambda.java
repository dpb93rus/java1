package ru.progwards.java2.lessons.recursion;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GoodsWithLambda {
    ArrayList <Goods> list = new ArrayList<>();

    void setGoods(List<Goods> list) { this.list = new ArrayList<>(list); }

    List<Goods> sortByPrice() {
        list.sort(Comparator.comparingDouble(a -> a.price));
        return list;

    }
    List<Goods> sortByName() {
        list.sort(Comparator.comparing(a -> a.name));
        return list;
    }

        List<Goods> sortByNumber() {
            list.sort(Comparator.comparing(a -> a.number.toUpperCase()));
        return list;
    }
    List<Goods> sortByPartNumber() {
        list.sort(Comparator.comparing(a -> a.number.toUpperCase().substring(0,2)));
        return list;
    }
//    List<Goods> sortByAvailabilityAndNumber() {
//        list = (ArrayList<Goods>) list.stream().sorted(new Comparator<Goods>() {
//            @Override
//            public int compare(Goods o1, Goods o2) {
//                if (o1.available > o2.available) return 1;
//                if (o1.available < o2.available) return -1;
//                if (o1.number.compareTo(o2.number) > 0) return 1;
//                if (o1.number.compareTo(o2.number) < 0) return -1;
//                return 0;
//            }
//        }).collect(Collectors.toList());
//        return list;
//    }

    List<Goods> sortByAvailabilityAndNumber() {
        list.sort((a, b) -> {
            if (a.available != b.available) return a.available - b.available;
            return a.number.toUpperCase().compareTo(b.number.toUpperCase());
        }); return list;
    }

//    List<Goods> expiredAfter(Instant date) {
//       return list.stream().filter(a -> a.expired.isAfter(date)).sorted(new Comparator<Goods>() {
//            @Override
//            public int compare(Goods o1, Goods o2) {
//               if (o1.expired.isAfter(o2.expired)) return 1;
//                if (o1.expired.isBefore(o2.expired)) return -1;
//                return 0;
//            }
//        }).collect(Collectors.toList());
//    }
    List<Goods> expiredAfter(Instant date) {
    return list.stream().filter(a -> a.expired.isAfter(date))
            .sorted(Comparator.comparing(a -> a.expired)).collect(Collectors.toList());
    }


    List<Goods> сountLess(int count) {
     return list.stream().filter(a -> a.available < count).collect(Collectors.toList());
    }
    List<Goods> сountBetween(int count1, int count2) {
        return list.stream().filter(a -> a.available < count2 & a.available > count1).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        GoodsWithLambda a = new GoodsWithLambda();
        a.list = new ArrayList<>(List.of(new Goods("Headlamp","Goods1",10,1500,Instant.MAX),
                new Goods("Giros","GAods2",2,7000,Instant.from(LocalDateTime.now().plusYears(2).atZone(ZoneId.systemDefault()))),new Goods("Signal","Goods3",3,6000,Instant.from(LocalDateTime.now().plusYears(5).atZone(ZoneId.systemDefault()))),
                new Goods("OBD","goods4",2,1200,Instant.from(LocalDateTime.now().plusYears(10).atZone(ZoneId.systemDefault()))),new Goods("Copter","GEods5",1,2000,Instant.from(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()))),
                new Goods("Watches","GBods6",2,2500,Instant.from(LocalDateTime.now().plusYears(3).atZone(ZoneId.systemDefault()))),new Goods("Ship","Goods7",4,10000,Instant.from(LocalDateTime.now().plusYears(4).atZone(ZoneId.systemDefault())))));
        System.out.println(a.сountBetween(3,5));
    }
}

