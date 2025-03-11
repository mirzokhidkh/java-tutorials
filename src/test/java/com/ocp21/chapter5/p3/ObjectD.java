package com.ocp21.chapter5.p3;

import com.ocp21.chapter5.p1.ObjectA;
import com.ocp21.chapter5.p2.ObjectB;

public class ObjectD {
    public void make(){
        ObjectB objectB = new ObjectB();
        objectB.make();

        ObjectA objectA = new ObjectA();
        objectA.staticName="";
    }
}
