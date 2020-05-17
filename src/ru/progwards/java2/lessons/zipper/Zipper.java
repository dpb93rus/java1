//package ru.progwards.java2.lessons.zipper;
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.*;
//public class Zipper {
//    public static void compressor(String[] files, String pathNameArchive, boolean compress) {
//        String[] checkedFiles = checkFiles(files);
//        Compressor archive = new Compressor(files,pathNameArchive,compress);
//        archive.compress();
//
//
//    }
//
//    public static void decompressor(String PathToCompressedFile){}
//
//    public static String[] checkFiles(String[] files) {
//        ArrayList<String> errors = new ArrayList<>();
//        HashSet<String> rightFiles = new HashSet<>();
//        for (String temp : files) {
//            if (!Files.exists(Path.of(temp))) errors.add(temp);
//            else rightFiles.add(temp);
//        }
//        if (errors.isEmpty()) return files;
//        if (errors.size() == files.length) {
//            System.out.println("Файлы не найдены");
//            return null;
//        }
//        System.out.println("Есть проблема. Некоторые файлы не найдены. Продолжить без них? Введите Y для продолжения или любое другое значение для отмены");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        if ("Y".equals(input)) {
//            String[] result = new String[rightFiles.size()];
//            int c = 0;
//            for (String t : rightFiles) {
//                result[c] = t;
//                c++;
//            }
//            return result;
//        }
//        System.out.println("Компрессия отменена пользователем");
//        return null;
//
//    }
//    public static void main(String[] args) {
//    String[] archive = {"C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\files\\Folder2\\S02-P01X12-0015.csv",
//            "C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\files\\Folder2\\S02-P01X12-0015.csvq"};
//    checkFiles(archive);
//    }
//}