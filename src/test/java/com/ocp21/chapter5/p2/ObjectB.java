package com.ocp21.chapter5.p2;

import com.ocp21.chapter5.p1.ObjectA;

public class ObjectB extends ObjectA{

    public static void main(String[] args) {
        ObjectB objectB = new ObjectB();

        objectB.code=1;

        System.out.println(objectB);

    }


    public void make(){
        doSomething();
        System.out.println(code);
    }

    public void doChildB(){
        ObjectB objectB = new ObjectB();
        objectB.doSomething();
    }



}
