package com.ocp21.chapter1;

public class Main {
    private String name = "11";

    {
        name = "1";
    }

    public static void main(String[] args) {

        System.out.println("Hello World");

        Main main = new Main();

        System.out.println(main.name);

        byte byteNum = 0;
        short shortNum = 0;
        int intNum = 0;
        long longNum = 0;
        float floatNum = 50.0f;
        double doubleNum = 10.0;
        char charNum = 0;

        Integer integerNum = 0;
        System.out.println(byteNum);
        System.out.println(shortNum);
        System.out.println(intNum);
        System.out.println(longNum);
        System.out.println(floatNum);
        System.out.println(doubleNum);
        System.out.println(charNum);

        System.out.println(integerNum);

        Bear bear = new Bear();

        int positiveNum = -101;
        positiveNum = ~positiveNum;
        System.out.println("negative= " + positiveNum);
        System.out.println("negative2 =" + ~0);




    }
}
