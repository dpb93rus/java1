package ru.progwards.java1.lessons.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.*;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class FindDuplicates {

    static ArrayList<File> files = new ArrayList<>();
    ArrayList<File> files2 = new ArrayList<>();

    public static void listOfFilesFromFolderTree(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                listOfFilesFromFolderTree(entry);
                continue;
            }
            files.add(entry);
        }
    }
    public static boolean equalsFiles (File f1, File f2) throws IOException {
        if (f1.getName().equals(f2.getName())) {
            if (Files.getLastModifiedTime(f1.toPath()).equals(Files.getLastModifiedTime(f2.toPath()))) {
                if (f1.getUsableSpace() == (f2.getUsableSpace())) {
                    String strF1 = Files.readString(f1.toPath());
                    String strF2 = Files.readString(f2.toPath());
                    if (strF1.equals(strF2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<List<String>> findDuplicates(String startPath) {
        HashSet <String> q = new HashSet<>();
        String t = "";
        ArrayList<List<String>> list = new ArrayList<>();
        File folder = new File(startPath);
        listOfFilesFromFolderTree(folder);
        for (int i = 0; i < files.size(); i++) {
            HashSet<String> sameFiles = new HashSet<>();
            for (int j = i+1; j < files.size(); j++) {
                try {
                    if (equalsFiles(files.get(i),(files.get(j)))&(!q.contains(files.get(i).getName()))) {
                        sameFiles.add(files.get(i).getPath());
                        sameFiles.add(files.get(j).getPath());
                        t = files.get(j).getName();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (!sameFiles.isEmpty()) list.add(new ArrayList<String>(sameFiles));
            q.add(t);
        }
        return list;
    }


    public static void main(String[] args) throws IOException {
        FindDuplicates A = new FindDuplicates();
        System.out.println(A.findDuplicates("C:\\Folder").toString());;
    }
}

