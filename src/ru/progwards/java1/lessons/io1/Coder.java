package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.*;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader reader = new FileReader(inFileName);
            StringBuffer D = new StringBuffer("");
            for (int c; (c = reader.read()) != -1; ) {
                D.append(code[(int) c]);
            }
            FileWriter writer = new FileWriter(outFileName, true);
            try {
                writer.write(D.toString());
            } finally {
                try {
                    writer.close();
                } catch (Throwable t) {
                    throw t;
                } finally {
                    try {
                        reader.close();
                    } catch (Throwable t) {
                        throw t;
                    }
                }
            }
        } catch (IOException e) {
            try {
                FileWriter writer = new FileWriter(logName, true);
                writer.write(e.getMessage());
                try {
                    writer.close();
                } catch (Throwable t) {
//                    t.printStackTrace();
                    throw t;
                }
            } catch (Throwable w) {
                System.out.println(w.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        String a = "abcdefghhjk";
        for (int i = 1; i <= 8; i++) {
            a += a;
        }
        try {
            codeFile("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\fileName.txt",
                    "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\file out", a.toCharArray(),
                    "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\logName");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}