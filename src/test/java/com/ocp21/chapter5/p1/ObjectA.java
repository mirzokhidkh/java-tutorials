package com.ocp21.chapter5.p1;

import lombok.ToString;

@ToString
public class ObjectA {

    String name;

    protected int code;

    private String password;

    public static String staticName = "staticName";

    protected void doSomething(){
        System.out.println("doSomething");
    }


    public static void main(String[] args) {
        ObjectF objectF = new ObjectF();
        ObjectE objectE = new ObjectE();
    }

}
