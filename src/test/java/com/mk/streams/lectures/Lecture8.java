package com.mk.streams.lectures;

import com.mk.streams.beans.Car;
import com.mk.streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lecture8 {


    @Test
    public void simpleGrouping() throws IOException {

        Map<String, List<Car>> grouping = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));

        grouping.forEach((make, cars) -> {
            System.out.println(make);
            cars.forEach(System.out::println);
        });


    }


    @Test
    public void groupingAndCounting() throws IOException {

        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> counting = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        counting.forEach((name, count) -> System.out.println(name + " > " + count));

    }


}
