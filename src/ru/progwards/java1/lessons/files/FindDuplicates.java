package ru.progwards.java1.lessons.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.*;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

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

    public List<List<String>> findDuplicates(String startPath) {
        ArrayList<List<String>> list = new ArrayList<>();
        File folder = new File(startPath);
        listOfFilesFromFolderTree(folder);
        for (File temp1 : files) {
            ArrayList<String> sameFiles = new ArrayList<>();
            int c = 0;
            for (File temp2 : files) {
                if (temp1.equals(temp2)) {
                    if (c == 0) {
                        sameFiles.add(temp1.getPath());
                        sameFiles.add(temp2.getPath());
                        c++;
                    } else sameFiles.add(temp2.getPath());
                }
            }
            list.add(sameFiles);
        }
        return list;
    }


    public static void main(String[] args) {
        FindDuplicates A = new FindDuplicates();
        System.out.println(A.findDuplicates("C:\\Folder").toString());;
    }
}

