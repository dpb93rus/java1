package ru.progwards.java1.lessons.io2;

        import java.io.FileReader;
        import java.io.FileWriter;

public class Censor {

    public static class CensorException extends RuntimeException {
        String info;
        String name;

        public CensorException(Throwable original, String fileName) {
            info = original.getMessage();
            name = fileName;
        }
        @Override
        public String getMessage() {
            return ("inoutFileName:" + info);
        }
    }
    public static void censorFile(String inoutFileName, String[] obscene) {
//      Считывание
        StringBuffer s = new StringBuffer("");
        try (FileReader reader = new FileReader(inoutFileName)) {
            for (int c; (c = reader.read()) != -1; ) {
                s.append((char) c);
            }
        } catch (Throwable EX) {
            throw new CensorException(EX, inoutFileName);
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
        } catch (Throwable EX) {
            throw new CensorException(EX,inoutFileName);
        }
    }

    public static void main(String[] args)  {
        String A[] = new String[]{"Java", "Oracle", "Sun", "Microsystems"};
        String fileName = "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\io2\\filin.txt";
        try {
            censorFile(fileName, A);
        } catch (Throwable EX) {
            new CensorException(EX, fileName);
            System.err.println(EX.getMessage());
        }
    }
}

