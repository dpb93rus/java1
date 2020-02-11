package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.*;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader reader = null;
            reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            StringBuffer D = new StringBuffer("");
            while (scanner.hasNextLine()) {
                StringBuffer S = new StringBuffer(scanner.nextLine());
                D.append(S);
                D.append("\n");
            }
            if (D.length() > 0) D.deleteCharAt(D.length() - 1);

            FileWriter writer = new FileWriter(outFileName, true);
            for (int n = 0; n < D.length(); n++) {
                char symbol = D.charAt(n);
                D.deleteCharAt(n);
                D.insert(n, code[(int) symbol]);
            }
            try {
                writer.write(String.valueOf(D));
            } finally {

                try {
                    writer.close();
                } catch (Throwable t) {
                    throw t;
                } finally {

                    try {
                        scanner.close();
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
            }
        } catch (IOException e) {
            try {
                FileWriter writer = new FileWriter(logName, true);
                writer.write(e.getMessage());
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
                    "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\file log");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}