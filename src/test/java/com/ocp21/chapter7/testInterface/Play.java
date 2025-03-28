package com.ocp21.chapter7.testInterface;

public interface Play {
    int count();

    default void work() {
        System.out.println(count());
    }
}
