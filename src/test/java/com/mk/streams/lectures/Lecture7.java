package com.mk.streams.lectures;

import com.mk.streams.beans.Car;
import com.mk.streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;

public class Lecture7 {


    @Test
    public void count() throws IOException {

        long count = MockData.getPeople()
                .stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .count();
        System.out.println(count);

    }


    @Test
    public void min() throws IOException {

        double min = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);

        System.out.println(min);


    }

    @Test
    public void max() throws IOException {
        double max = MockData.getCars()
                .stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);

        System.out.println(max);

    }


    @Test
    public void average() throws IOException {

        double average = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(average);
    }

    @Test
    public void sum() throws IOException {

        double sum = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice)
                .sum();

        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
        System.out.println(sum);

        System.out.println(bigDecimalSum);

    }

    @Test
    public void statistics() throws IOException {

        DoubleSummaryStatistics statistics = MockData.getCars()
                .stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();

        System.out.println(statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());

    }


}
