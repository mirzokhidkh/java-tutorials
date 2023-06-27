package com.mk.streams.lectures;

import com.mk.streams.beans.Car;
import com.mk.streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lecture9 {


    @Test
    public void reduce() throws IOException {

        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sum = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = Arrays.stream(integers).reduce(0, Integer::sum);

        System.out.println(sum2);
    }


}
