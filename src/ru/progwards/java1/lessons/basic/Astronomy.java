package ru.progwards.java1.lessons.basic;

public class Astronomy {
        public static Double sphereSquare (Double r){
            double p = 3.14;
            Double s = 4 * p * r * r;
            return s;
        }

        public static Double earthSquare () {
            double ES = sphereSquare(6371.2);
            return ES;
        }

        public static Double mercurySquare () {
            double MS = sphereSquare(2439.7);
            return MS;
        }

        public static Double jupiterSquare () {
            double US = sphereSquare(71492.0);
            return US;
        }

        public static Double earthVsMercury () {
            double OEM = earthSquare() / mercurySquare();
            return OEM;
        }

        public static Double earthVsJupiter () {
            double OEU = earthSquare() / jupiterSquare();
            return OEU;
        }
    public static void main(String[] args) {
            double a = earthSquare ();
        double b = mercurySquare ();
        double c = jupiterSquare ();
        double d = earthVsMercury ();
        double e = earthVsJupiter ();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
