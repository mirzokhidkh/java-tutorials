package com.mk.ocp.chapter1;

public class Main {
    private String name="11";

    {
        name = "1";
    }

    public static void main(String[] args) {

        System.out.println("Hello World");

        Main main = new Main();

        System.out.println(main.name);

    }
}
