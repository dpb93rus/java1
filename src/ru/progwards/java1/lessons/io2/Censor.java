package ru.progwards.java1.lessons.io2;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;

public class Censor {

    public static class CensorException extends RuntimeException {
        String info;
        String name;

        public CensorException(Exception original) {
            this.info = original.getMessage();
            this.name = this.getMessage();
        }

        public static void censorFile(String inoutFileName, String[] obscene) throws IOException {
//      Считывание
            StringBuffer s = new StringBuffer("");
            try (FileReader reader = new FileReader(inoutFileName)) {
                for (int c; (c = reader.read()) != -1; ) {
                    s.append((char) c);
                }
            } catch (IOException EX) {
                throw EX;
            }
//      Формируем выходной текст
            for (int c = 0; c < obscene.length; c++) {
                StringBuffer temp2 = new StringBuffer("");
                if (s.indexOf(obscene[c]) != -1) {
                    for (int g = 0; g < obscene[c].length(); g++) {
                        temp2.append("*");
                    }
                    s.replace(s.indexOf(obscene[c]), s.indexOf(obscene[c]) + obscene[c].length(), temp2.toString());
                }
                if (s.indexOf(obscene[c]) != -1) c--;
            }
            try (FileWriter writer = new FileWriter(inoutFileName)) {
                writer.write(s.toString());
            } catch (IOException EX) {
            }
        }

        public static void main(String[] args) {
            try {
                censorFile("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io2\\filin.txt", new String[]{"Java", "Oracle", "Sun", "Microsystems"});
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
