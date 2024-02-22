package com.mk.concurrency.future.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WriterAsync implements Runnable {

    private final Map.Entry<String, String[]> curFolder;
    private final String sourcePath;

    private final String targetPath;


    public WriterAsync(Map.Entry<String, String[]> curFolder, String sourcePath, String targetPath) {
        this.curFolder = curFolder;
        this.sourcePath = sourcePath;
        this.targetPath = targetPath;
    }


    @Override
    public void run() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
//         String ANSI_CYAN_BACKGROUND = "\u001B[46m";

        long start = System.currentTimeMillis();

        // Create an ExecutorService to perform operations asynchronously
        ExecutorService writerExecutor = Executors.newFixedThreadPool(5);

        String folderName = curFolder.getKey();
        String[] fileNames = curFolder.getValue();
        int n = fileNames.length;
        InputStream[] inputStreams = new InputStream[n];
        CompletableFuture<Void>[] completableFutures = new CompletableFuture[n];
        int i;
        for (i = 0; i < n; i++) {
            String filePath = Paths.get(sourcePath, folderName, fileNames[i]).toString();
            try {
                inputStreams[i] = getInputStreamForFile(filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            completableFutures[i] = writeAsync(targetPath, folderName, fileNames[i], inputStreams[i], writerExecutor);
        }

        // Combine all CompletableFuture to wait for all file writes to complete
        CompletableFuture<Void> allWrites = CompletableFuture.allOf(completableFutures);

        allWrites.join();
        System.out.println("TEST");
        // Attach a callback to perform cleanup or other operations after all writes are done
//        allWrites.thenRunAsync(() -> {

//            System.out.println("All file writes completed successfully in folder "+folderName);
//             Shutdown the ExecutorService
        writerExecutor.shutdown();
//        });

        long end = System.currentTimeMillis();
        System.out.println(ANSI_GREEN_BACKGROUND + n + " files saved " + "in  folder " + folderName + "- TOTAl TIME (seconds) ===> " + (end - start) / 1000 + ANSI_RESET);


    }


    // Replace these methods with actual methods to obtain InputStreams for your files
    private InputStream getInputStreamForFile(String path) throws FileNotFoundException {
        InputStream targetStream = new FileInputStream(path);
//        return new ByteArrayInputStream("Content of file1 mmm".getBytes());
        return targetStream;
    }

    private CompletableFuture<Void> writeAsync(String targetPath, String folderName, String fileName, InputStream inputStream, ExecutorService executorService) {
        return CompletableFuture.runAsync(() -> {
            try {
                // Ensure the folder exists
                Files.createDirectories(Paths.get(targetPath, folderName));

                // Combine the folder path and file name
//                String filePath = Paths.get(folderPath, fileName).toString();

                // Write the InputStream to the file
//                try (OutputStream outputStream = new FileOutputStream(filePath)) {
                try (OutputStream outputStream = Files.newOutputStream(Paths.get(targetPath, folderName, fileName))) {
                    byte[] buffer = new byte[1024 * 1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                } finally {
                    inputStream.close();
                }

                System.out.println("File '" + fileName + "' written successfully in folder " + folderName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, executorService);
    }


}
