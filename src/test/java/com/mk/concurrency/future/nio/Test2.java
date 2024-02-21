package com.mk.concurrency.future.nio;

import java.io.File;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAllFileNames("D:\\my-desktop\\mini-desktop\\fb\\file-transfer-agent\\files\\WHP150101160601F002")));
    }


    public static String[] getAllFileNames(String folderPath) {
        File folder = new File(folderPath);

        // Check if the folder exists and is a directory
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Invalid folder path: " + folderPath);
        }

        // Get all files in the folder
        File[] files = folder.listFiles();

        // Extract filenames from File objects
        String[] filenames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            filenames[i] = files[i].getName();
        }

        return filenames;
    }

}


