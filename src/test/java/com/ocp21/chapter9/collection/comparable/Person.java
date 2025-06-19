package com.ocp21.chapter9.collection.comparable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public record Person(String name, int age) implements Comparable<Person> {
    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }


    public static void main(String[] args) {
        String s = "a";

        System.out.println(s.compareTo("ab"));


        Person p1 = new Person("a", 1);
        Person p2 = new Person("az", 2);
        Person p3 = new Person("ab", 2);

        List<Person> list = Arrays.asList(p1, p2, p3);

        Collections.sort(list);

        System.out.println(list);
    }
}
