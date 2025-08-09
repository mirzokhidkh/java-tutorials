package com.ocp21.chapter13_Concurrency.thread.executorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {


        Runnable printInventory = () -> {};
        Runnable printRecords = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printRecords");
        };

        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            System.out.println("begin");
            service.execute(printInventory);
            service.execute(printRecords);
            service.execute(printInventory);
            System.out.println("end");
        }

    }
}
