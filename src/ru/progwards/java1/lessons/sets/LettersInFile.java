package ru.progwards.java1.lessons.sets;

        import java.io.FileReader;
        import java.io.IOException;
        import java.util.HashSet;
        import java.util.Iterator;
        import java.util.TreeSet;

public class LettersInFile {

    public static String process(String fileName) throws IOException {
        StringBuffer res = new StringBuffer();
        TreeSet<String> tree = new TreeSet();
        try (FileReader reader = new FileReader(fileName)) {
            for (int c; (c = reader.read()) != -1;) {
                if ((c >=0x0041)&(c<=0x005A)|(c >=0x0061)&(c<=0x007A)|(c>=0x0410)&(c<=0x044F))
                tree.add(""+(char)c);
            }
        } catch (Throwable EX) {
            throw new IOException(EX);
        }
        for (String t:tree) res.append(t);
        return res.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(process("C:/Users/Dmitry/IdeaProjects/java1/src/ru/progwards/java1/lessons/sets/Текст.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
