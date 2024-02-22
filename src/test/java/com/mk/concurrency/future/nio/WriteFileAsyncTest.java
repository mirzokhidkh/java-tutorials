package com.mk.concurrency.future.nio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

public class WriteFileAsyncTest {
    static final String sourcePath = "D:\\my-desktop\\mini-desktop\\fb\\file-transfer-agent\\files\\test";
    static final String targetPath = "files";
    static int i = 0;

    public static void main(String[] args)  {

//        // Optionally, you can wait for the completion of all file writes
//        try {
//            allWrites.get(); // This will block until all file writes are completed
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                System.out.println(formatter.format(now));
                if(i==0) {
                    testAsync();
                }
                i++;
            }
        };
        timer.schedule(tt, 500, 5000);
    }

    private static void testAsync() {
        String ANSI_RESET = "\u001B[0m";
//        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
         String ANSI_CYAN_BACKGROUND = "\u001B[46m";

        long start = System.currentTimeMillis();

//        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        List<Future<?>> futures = new ArrayList<>();

        // Specify the folder where files will be written
        HashMap<String, String[]> map = getFolderMap(sourcePath);
        for (Map.Entry<String, String[]> curFolder : map.entrySet()) {
            WriterAsync writerAsync = new WriterAsync(curFolder, sourcePath, targetPath);
            Future<?> future = executor.submit(writerAsync);
            futures.add(future);
        }

        // Wait for all threads to complete
        for (Future<?> future : futures) {
            try {
                future.get(); // This will block until the task is completed
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(ANSI_CYAN_BACKGROUND+"TOTAl TIME  all folders (seconds) ===> " + (end - start) / 1000+ANSI_RESET);
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
