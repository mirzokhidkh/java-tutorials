package com.ocp21.chapter13_Concurrency.thread.executorExample;

import java.util.concurrent.Executors;

public class Main2 {
    public static void main(String[] args) {
        var service = Executors.newSingleThreadExecutor();
        service.submit(() -> System.out.println("Never stops"));
        service.close();
    }
}
