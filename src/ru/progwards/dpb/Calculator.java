package ru.progwards.dpb;

public class Calculator {
    enum Grade {

        VERYBAD,

        BAD,

        SATISFACTORILY,

        GOOD,

        EXCELLENT,

        NOTDEFINED,

    }

    static Grade intToGrade(int grade) {

        switch (grade) {

            case 1:
                System.out.println(Grade.VERYBAD);
                return Grade.VERYBAD;


            case 2:
                System.out.println(Grade.BAD);
                return Grade.BAD;


            case 3:
                System.out.println(Grade.SATISFACTORILY);
                return Grade.SATISFACTORILY;


            case 4:
                System.out.println(Grade.GOOD);
                return Grade.GOOD;


            case 5:
                System.out.println(Grade.EXCELLENT);
                return Grade.EXCELLENT;


            default:
                System.out.println(Grade.NOTDEFINED);
                return Grade.NOTDEFINED;

        }

    }

    public static void main(String[] args) {
        intToGrade(4);
    }
}