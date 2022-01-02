package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) throws IOException {

        StringBuilder log  = new StringBuilder();

        createFewDirectories(log, new File("/Users/User/IdeaProjects/Установка/src/Games"), "src", "res", "savegames", "temp");
        createFewDirectories(log, new File("/Users/User/IdeaProjects/Установка/src/Games/src"), "main", "test");
        createFewDirectories(log, new File("/Users/User/IdeaProjects/Установка/src/Games/res"), "drawables", "vectors", "icons");

        createFewFiles(log, new File("/Users/User/IdeaProjects/Установка/src/Games/src/main/"), "Main.java", "Utils.java");
        createFewFiles(log, new File("/Users/User/IdeaProjects/Установка/src/Games/temp"), "temp.txt");

        String resultLog = log.toString();

        try (FileWriter temp = new FileWriter("/Users/User/IdeaProjects/Установка/src/Games/temp/temp.txt", false)) {
            temp.write(resultLog);
            temp.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void createFewDirectories(StringBuilder log, File file, String... folders) {

        for (String str : folders) {
            File foldersFile = new File(file, str);
            foldersFile.mkdir();
            log.append(LocalDateTime.now() + ": new directory - " + str + "\n");
        }
    }

    private static void createFewFiles(StringBuilder log, File file, String... files) {

        try {
            for (String str : files) {
                File fewFile = new File(file, str);
                fewFile.createNewFile();
                log.append(LocalDateTime.now() + ": new file - " + str + "\n");
            }
        } catch (IOException exception) {
            System.out.println("file creation error");
        }
    }
}