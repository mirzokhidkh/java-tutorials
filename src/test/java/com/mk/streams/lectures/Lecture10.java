package com.mk.streams.lectures;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lecture10 {

    private static final List<ArrayList<String>> arrayListOfNames = Lists.newArrayList(
            Lists.newArrayList("Mariam", "Alex", "Ismail"),
            Lists.newArrayList("John", "Alesha", "Andre"),
            Lists.newArrayList("Susy", "Ali")
    );


    @Test
    public void setUp() throws IOException {


    }

    @Test
    public void withoutFlatMap() throws IOException {

        ArrayList<Object> names = Lists.newArrayList();

        for (ArrayList<String> listOfNames : arrayListOfNames) {
            for (String name : listOfNames) {
                names.add(name);
            }
        }

        System.out.println(names);
    }


    @Test
    public void withFlatMap() throws IOException {

        List<String> names = arrayListOfNames.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(names);

    }



}
