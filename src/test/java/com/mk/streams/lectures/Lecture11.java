package com.mk.streams.lectures;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Lecture11 {


    @Test
    public void joiningStrings() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"

        String join = "";

        for (String name : names) {
            join += name + ", ";
        }

        System.out.println(join.substring(0, join.length() - 2));

    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"

        String joining = names.stream()
                .collect(Collectors.joining(","));

        System.out.println(joining);

    }


}
