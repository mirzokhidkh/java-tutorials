package com.ocp21.chapter5;

public class Test {

    private String name="NAME";
    private static int count = 0;

    static {
        System.out.println(count);
    }

    {
        count++;
        System.out.println(count);
    }
     public Test() {
         System.out.println("CONSTRUCT");
     }



    public static void main(String[] args) {
        System.out.println("main");
        new Test();
    }
}
