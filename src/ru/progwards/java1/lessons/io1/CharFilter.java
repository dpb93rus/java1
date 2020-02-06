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
        StringBuffer S = new StringBuffer(scanner.nextLine());
        StringBuffer D = new StringBuffer("");
        try {
            FileWriter writer = new FileWriter(outFileName, true);
                while (scanner.hasNextLine()) {
                    for (int n = 0; n < S.length(); n++) {
                        int T = S.length();
                        for (int c = 0; c < filter.length(); c++) {
                            if (((S.charAt(n)) + "").equals(filter.charAt(c) + "")) {
                                S.deleteCharAt(n);
                            }
                        }
                        if (T!=S.length()) n--;
                    }
                    D.append(S);
                    D.append("\n");
                    S = new StringBuffer(scanner.nextLine());
                }

            for (int n = 0; n < S.length(); n++) {
                int T = S.length();
                for (int c = 0; c < filter.length(); c++) {
                    if (((S.charAt(n)) + "").equals(filter.charAt(c) + "")) {
                        S.deleteCharAt(n);
                    }
                }
                if (T!=S.length()) n--;
            }
            D.append(S);
            try {
                writer.write(String.valueOf(D));
            } finally {

                reader.close();
                scanner.close();
                writer.close();
            }
        } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }



        public static void main(String[] args) {
        filterFile("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\fileName.txt",
                "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io1\\file out", " ");
    }
}