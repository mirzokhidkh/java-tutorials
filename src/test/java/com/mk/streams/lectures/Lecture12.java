package com.mk.streams.lectures;

import com.mk.streams.beans.Person;
import com.mk.streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lecture12 {


    @Test
    public void understandingCollect() throws Exception {

        ArrayList<Object> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(ArrayList::new,
                        ArrayList::add,
                        (list1, list2) -> list1.addAll(list2)
                );

        System.out.println(emails);
    }


}
