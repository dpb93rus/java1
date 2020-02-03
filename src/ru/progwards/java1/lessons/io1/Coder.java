package ru.progwards.java1.lessons.io1;
import java.io.*;
import java.util.*;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        FileReader reader = null;
        Throwable T = new Throwable();
        try {
            reader = new FileReader(inFileName);
        } catch (FileNotFoundException e) {
            T = e;
        }
        Scanner scanner = new Scanner(reader);
        StringBuffer D = new StringBuffer("");
        while (scanner.hasNextLine()) {
            StringBuffer S = new StringBuffer(scanner.nextLine());
            D.append(S);
            D.append("\n");
        }
        D.deleteCharAt(D.length());
        try {
            FileWriter writer = new FileWriter(outFileName, true);
            for (int n = 0; n < D.length(); n++) {
                char symbol = D.charAt(n);
                D.deleteCharAt(n);
                D.insert(n, code[(int) symbol]);
            }

            try {
                writer.write(String.valueOf(D));
            } finally {

                reader.close();
                scanner.close();
                writer.close();
            }
        } catch (IOException e) {
            try {
                FileWriter writer = new FileWriter(outFileName, true);
                writer.write(T.getMessage());
            } catch (Throwable w) {
                System.out.println(w.getMessage());
            }
        }
    }
}