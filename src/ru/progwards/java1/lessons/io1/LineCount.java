package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        int i = 0;
        try (FileReader reader = new FileReader(fileName);
             Scanner scanner = new Scanner(reader)) {
            do {
                String s = scanner.nextLine();
                if (s == "") i++;
                scanner.nextLine();
            }
            while (scanner.hasNextLine());
        } catch (Exception e) {
            return -1;
        }

        return i;
    }
}

