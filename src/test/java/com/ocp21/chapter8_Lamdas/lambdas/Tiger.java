package com.ocp21.chapter8_Lamdas.lambdas;

public class Tiger implements Sprint {

    @Override
    public void dive() {
        System.out.println("Hello World");
    }


    public static void main(String[] args) {

        Tiger tiger = new Tiger();
        tiger.dive();
    }
}
