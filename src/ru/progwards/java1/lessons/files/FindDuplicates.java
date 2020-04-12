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

    ArrayList<File> files = new ArrayList<>();
    ArrayList<File> files2 = new ArrayList<>();

    public void processFilesFromFolder(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFilesFromFolder(entry);
                continue;
            }
            files.add(entry);
        }
    }

    public List<List<String>> findDuplicates(String startPath) {
        ArrayList<List<String>> list = new ArrayList<>();
        File folder = new File(startPath);
        processFilesFromFolder(folder);
        for (File temp1 : files) {
            ArrayList<String> sameFiles = new ArrayList<>();
            int c = 0;
            for (File temp2 : files) {
                if (temp1.equals(temp2)) {
                    if (c == 0) {
                        sameFiles.add(temp1.getAbsolutePath());
                        sameFiles.add(temp2.getAbsolutePath());
                        c++;
                    } else files2.add(temp2);
                }
            }
            list.add(sameFiles);
        }
        return list;
    }

    public static void main(String[] args) {
        FindDuplicates A = new FindDuplicates();
        A.findDuplicates("C:\\Users\\Dmitry\\IdeaProjects\\java1\\src\\ru\\progwards\\java1\\lessons\\files\\Folder");
    }
}

