package com.ocp21.chapter9.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ListExample {
    public static void main(String[] args) {

        String[] strings = new String[]{"a", "b", "c", "d", "e", "f", "g", "a"};
//        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

//        List<String> list = Arrays.asList(strings);
        List<String> list = List.of(strings);

        System.out.println("BEFORE" + list);

        System.out.println(list.set(0, "z"));

        System.out.println("AFTER" + list);


        System.out.println(list.lastIndexOf("a"));

//        list.remove()

        list.sort(String::compareTo);




    }
}
