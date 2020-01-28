package ru.progwards.java1.lessons.io1;


import java.io.*;
import java.util.*;


public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader reader = new FileReader(inFileName);
        Scanner scanner = new Scanner(reader);
        FileWriter writer = new FileWriter(outFileName, true);

        StringBuffer S = new StringBuffer(scanner.nextLine());
        for (int n = 1; n < S.length(); n++) {
            if (((S.charAt(n)) + "").equals(filter)) {
                S.deleteCharAt(n);
                n--;
            }
        }
        writer.write(String.valueOf(S));
        reader.close(); scanner.close(); writer.close();
    }


    public static void main(String[] args) throws IOException {
        filterFile("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\fileName.txt",
                "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\file out","h");
    }
}