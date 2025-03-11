package com.ocp21.chapter5;

public class InitializingObject {
    static {
        System.out.println("A");
    }
}

class Initializer extends InitializingObject{
    public static void main(String[] args) {
        System.out.println("C");
//        new Initializer();
//        new Initializer();
    }
    static {
        System.out.println("B");
    }
}
