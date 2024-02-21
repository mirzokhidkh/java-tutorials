package com.mk.concurrency.future.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        // Specify the folder where files will be written
        String sourcePath = "D:\\my-desktop\\mini-desktop\\fb\\file-transfer-agent\\files\\test";
        String targetPath = "files";

        for (Map.Entry<String, String[]> folderMap : getFolderMap(sourcePath).entrySet()) {
            long start = System.currentTimeMillis();

            // Create an ExecutorService to perform operations asynchronously
            ExecutorService executorService = Executors.newFixedThreadPool(3);

            String folderName = folderMap.getKey();
            String[] fileNames = folderMap.getValue();
            int n = fileNames.length;
            InputStream[] inputStreams = new InputStream[n];
            CompletableFuture<Void>[] completableFutures = new CompletableFuture[n];
            int i;
            for (i = 0; i < n; i++) {
                String filePath = Paths.get(sourcePath, folderName, fileNames[i]).toString();
                inputStreams[i] = getInputStreamForFile(filePath);
                completableFutures[i] = writeAsync(targetPath + "\\" + folderName, fileNames[i], inputStreams[i], executorService);
            }

            // Combine all CompletableFuture to wait for all file writes to complete
            CompletableFuture<Void> allWrites = CompletableFuture.allOf(completableFutures);

            allWrites.join();
            System.out.println("TEST");
            // Attach a callback to perform cleanup or other operations after all writes are done
            allWrites.thenRunAsync(() -> {
                System.out.println("All file writes completed successfully.");
                // Shutdown the ExecutorService
                executorService.shutdown();
            });

            long end = System.currentTimeMillis();


            System.out.println(n + " files saved - TOTAl TIME (seconds) ===> " + (end - start) / 1000);
        }


//        // Optionally, you can wait for the completion of all file writes
//        try {
//            allWrites.get(); // This will block until all file writes are completed
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private static CompletableFuture<Void> writeAsync(String targetPath, String fileName, InputStream inputStream, ExecutorService executorService) {
        return CompletableFuture.runAsync(() -> {
            try {
                // Ensure the folder exists
                Files.createDirectories(Paths.get(targetPath));

                // Combine the folder path and file name
//                String filePath = Paths.get(folderPath, fileName).toString();

                // Write the InputStream to the file
//                try (OutputStream outputStream = new FileOutputStream(filePath)) {
                try (OutputStream outputStream = Files.newOutputStream(Paths.get(targetPath, fileName))) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }

                System.out.println("File '" + fileName + "' written successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, executorService);
    }

    // Replace these methods with actual methods to obtain InputStreams for your files
    private static InputStream getInputStreamForFile(String path) throws FileNotFoundException {
        InputStream targetStream = new FileInputStream(path);
//        return new ByteArrayInputStream("Content of file1 mmm".getBytes());
        return targetStream;
    }


    public static HashMap<String, String[]> getFolderMap(String path) {
        HashMap<String, String[]> map = new HashMap<>();
        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Invalid folder path: " + path);
        }
        File[] files = folder.listFiles();
//        String[] folderNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            map.put(files[i].getName(), getAllFileNamesByFolder(path, files[i].getName()));
        }
        return map;
    }

    public static String[] getAllFileNamesByFolder(String path, String folderName) {
        String fullPath = Paths.get(path, folderName).toString();

        File folder = new File(fullPath);

        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Invalid folder path: " + fullPath);
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
