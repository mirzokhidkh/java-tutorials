package com.mk.streams.lectures;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Predicate;

public class Lecture6 {


    @Test
    public void findAny() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int any = Arrays.stream(numbers)
                .filter(getNumbersLessThan10())
                .findAny()
                .get();

        System.out.println(any);


    }


    @Test
    public void findFirst() {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int first = Arrays.stream(numbers)
                .filter(getNumbersLessThan10())
                .findFirst()
                .get();

        System.out.println(first);
    }

    private static Predicate<Integer> getNumbersLessThan10() {
        return n -> n > 5 && n < 10;
    }
}
