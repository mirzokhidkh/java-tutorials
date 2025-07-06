package com.ocp21.chapter9.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("brown bear-", "grizzly-");
        s.sorted(Comparator.reverseOrder()).forEach(s1 -> System.out.println(s1));  // DOES NOT COMPILE
    }
}
