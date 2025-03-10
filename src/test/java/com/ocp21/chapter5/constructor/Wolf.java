package com.ocp21.chapter5.constructor;

public class Wolf extends Animal {
    private String name;
    public Wolf() {
        System.out.println("Wolf");
    }

    public Wolf(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Wolf wolf = new Wolf("a");

    }
}
