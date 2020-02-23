package ru.progwards.dpb;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Throw {
    public static String setStars(String filename) throws IOException {
        StringBuffer s = new StringBuffer("");
        try (FileReader reader = new FileReader(filename)) {
            for (int c; (c = reader.read()) != -1; ) {
                s.append((char) c);
            }
        } catch (IOException EX) {
            EX.getMessage();
            throw EX;
        }
        StringBuffer d = new StringBuffer("");
        for (int c = 9; c < (s.length()/10);c = c+10) {
            d.append(s.subSequence(c,c+1));
            s.replace(c,c+1,"*");
        }
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(s.toString());
        } catch (IOException EX) {
            EX.getMessage();
            throw EX;
        }
        return d.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(setStars("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\dpb\\filename.txt"));
    }
}
