//package ru.progwards.java1.lessons.files;
//
//import java.io.File;
//import java.nio.file.Path;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class OrderProcessor {
//    Path workDir; static ArrayList<File> files = new ArrayList<>();
//    public OrderProcessor(String startPath){
//        workDir = Path.of(startPath);
//    }
//
//    public static void listOfFilesFromFolderTree(File folder) {
//        File[] folderEntries = folder.listFiles();
//        for (File entry : folderEntries) {
//            if (entry.isDirectory()) {
//                listOfFilesFromFolderTree(entry);
//                continue;
//            }
//            files.add(entry);
//        }
//    }
//    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
//
//    }
//    public List<Order> process(String shopId) {
//
//    }
//    public Map<String, Double> statisticsByShop() {
//
//    }
//    public Map<String, Double> statisticsByGoods() {
//
//    }
//    public Map<LocalDate, Double> statisticsByDay() {
//
//    }
//}
