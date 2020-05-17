//package ru.progwards.java2.lessons.zipper;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//
//public class Compressor {
//    String pathNameArchive;
//    boolean compress;
//    String[] pathFiles;
//    StringBuffer tempString;
//    int encodeTableCapacity;
//    public Compressor(String[] files,String pathNameArchive,boolean compress){
//        this.pathNameArchive = pathNameArchive;
//        this.compress = compress;
//        this.pathFiles = files;
//        tempString = new StringBuffer("");
//    }
//    public void compress() {
//        File archive = new File(this.pathNameArchive);
//
//    }
//    public PriorityQueue1<Node> nodeQueueFromFile(String pathFile) {
//        PriorityQueue1<Node> q = new PriorityQueue1<>();
//        HashMap <Character, Integer> listChar = new HashMap<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(new File(pathFile)))) {
//            int c; char symbol;
//            while ((c = reader.read()) != -1) {
//                symbol = (char)c;
//                tempString.append(symbol);
//                if (listChar.containsKey(symbol)) listChar.put(symbol, listChar.get(symbol)+1);
//                else listChar.put(symbol, 1);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.err.println("Ошибка чтения файла " + pathFile + " в методе nodeQueue");
//            return null;
//        }
//        if (listChar.isEmpty()) {
//            System.out.println("Файл " + pathFile + " без содержимого и не будет архивирован");
//            return q;
//        }
//        encodeTableCapacity = listChar.size();
//        for (Map.Entry<Character, Integer> e: listChar.entrySet()) {
//            q.offer(new Node(e.getKey(),e.getValue()));
//        }
//    return q;
//    }
//    public BinaryTree TreeFromQueue (PriorityQueue1<Node> pq){
//        while (pq.size()>1) {
//        Node a = pq.poll(); Node b = pq.poll();
//        Node c = new Node
//
//    }
//
//
//
//




//}
