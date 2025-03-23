package com.ocp21.chapter8_Lamdas.lambdas;

@FunctionalInterface
public  interface Sprint {
     String toString();
    public boolean equals(Object o);
    public abstract int hashCode();
    public abstract void dive();
}
