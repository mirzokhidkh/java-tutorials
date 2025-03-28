package com.ocp21.chapter7.testInterface;

public class Example implements Play{
    @Override
    public int count() {
        return 11;
    }

    @Override
    public void work() {
        Play.super.work();
    }


    public static void main(String[] args) {
        Example example = new Example();
        example.work();
    }
}
