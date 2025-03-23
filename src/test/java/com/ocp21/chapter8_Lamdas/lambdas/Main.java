package com.ocp21.chapter8_Lamdas.lambdas;

interface StringChecker {
    boolean check();
}

interface StringStart {
    boolean beginningCheck(String prefix);
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        var str = "";
        StringChecker lambda = () -> str.startsWith("Zoo");

        StringStart methodRef = str::startsWith;

//        StringChecker methodReference0 = str::startsWith;         // DOES NOT COMPILE

//        StringChecker methodReference = str::startsWith ("Zoo");
    }
}
