package com.ocp21.chapter13_Concurrency.thread.join;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable worker = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("join-1-" + i);
            }
        };

        Thread thread = Thread.ofPlatform()
//                .daemon(true)
                .start(worker);
        thread.join();

        for (int j = 0; j < 10; j++) {
            System.out.println("main-1-" + j);
        }


    }

}
