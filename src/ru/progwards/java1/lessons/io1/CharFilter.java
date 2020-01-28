package ru.progwards.java1.lessons.io1;


import java.io.*;
import java.util.*;


public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) {
        FileReader reader = null;
        try {
            reader = new FileReader(inFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(reader);
        FileWriter writer = null;
        try {
            writer = new FileWriter(outFileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer S = new StringBuffer(scanner.nextLine());
        for (int n = 1; n < S.length(); n++) {
            if (((S.charAt(n)) + "").equals(filter)) {
                S.deleteCharAt(n);
                n--;
            }
        }
        try {
            writer.write(String.valueOf(S));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        filterFile("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\fileName.txt",
//                "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\file out"," ");
//    }
}