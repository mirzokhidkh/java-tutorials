package com.ocp21.chapter13_Concurrency.thread.test1;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        var threads = Stream.generate(() -> Thread.ofPlatform()
                        .unstarted(PlatformVsVirtual::waitUp))
                .limit(1_000_000)
                .toList();
        threads.forEach(Thread::start);
        for (var t : threads)
            t.join();

        System.out.println("SS");
    }
}
