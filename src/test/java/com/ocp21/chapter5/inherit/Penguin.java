package com.ocp21.chapter5.inherit;

public class Penguin extends Bird {
    private final void flyAway(){
        System.out.println("penguin flyAway");
    }

    public static void main(String[] args) {
        Penguin p = new Penguin();
        p.flyAway();

        Bird b = new Penguin();
    }
}
