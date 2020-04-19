package ru.progwards.java1.lessons.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FilesSelect {
    static ArrayList<File> files = new ArrayList<>();
    public static void listOfFilesFromFolderTree(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                listOfFilesFromFolderTree(entry);
                continue;
            }
            if (entry.getName().toUpperCase().contains(".TXT")) files.add(entry);
        }
    }

    public void selectFiles(String inFolder, String outFolder, List<String> keys) {
        listOfFilesFromFolderTree(new File(inFolder));
        for (File temp : files) {
            String t = null;
            try {
                t = Files.readString(temp.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (String key : keys) {
                if (t.contains(key)) {
                    Path directoryOut = Paths.get(outFolder).resolve(key);
                    if (!Files.exists(directoryOut)) {
                        try {
                            Files.createDirectory(directoryOut);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    Path test = directoryOut.resolve(temp.getName());
                    if (!Files.exists(test)) {
                        try {
                            Files.copy(temp.toPath(), test);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {



        FilesSelect A = new FilesSelect();
        try {
            A.selectFiles("C:\\Folder2", "C:\\FoldOut", new ArrayList<String>(List.of("звук", "течение", "жизней")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}