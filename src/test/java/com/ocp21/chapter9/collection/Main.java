package com.ocp21.chapter9.collection;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Double> randoms = Stream.generate(Math::random);
        System.out.println(randoms.toList().size());
    }
}
