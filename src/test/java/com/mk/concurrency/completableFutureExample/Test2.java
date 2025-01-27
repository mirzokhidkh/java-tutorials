package com.mk.concurrency.completableFutureExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class Test2 {


    public static void main(String[] args) {

        List<CompletableFuture<Void>> futures = new ArrayList<>();


        futures.add(CompletableFuture.runAsync(() -> {
            try {
                System.out.println("0");
            } catch (Exception e) {
                throw new RuntimeException("Error in setPerformedServices 0", e);
            }
        }));


        futures.add(CompletableFuture.runAsync(() -> {
            try {
                System.out.println("1");
                throw new RuntimeException();
            } catch (Exception e) {
                throw new RuntimeException("Error in setPerformedServices 1", e);
            }
        }));

//        CompletableFuture.allOf(future1).join();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();  // Blocks until all futures are done

    }
}
