package com.ocp21.chapter13_Concurrency.thread.test1;

public class PlatformVsVirtual {
    static void waitUp() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}