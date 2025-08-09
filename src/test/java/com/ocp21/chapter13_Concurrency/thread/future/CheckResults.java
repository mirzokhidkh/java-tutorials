package com.ocp21.chapter13_Concurrency.thread.future;

import java.util.concurrent.*;

public class CheckResults {
    private static int counter = 0;

    public static void main(String[] unused) throws Exception {
        try (var service = Executors.newSingleThreadExecutor()) {
            Future<?> result = service.submit(() -> {
                try {
                    Thread.sleep(900); // Simulate some work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 1_000_000; i++) counter++;
            });
            result.get(1, TimeUnit.SECONDS);  // Returns null for Runnable
            System.out.println("Reached!");
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        }
    }
}