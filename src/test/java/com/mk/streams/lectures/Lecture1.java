package com.mk.streams.lectures;

import com.mk.streams.beans.Person;
import com.mk.streams.mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class Lecture1 {

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();

        List<Person> youngPeople = Lists.newArrayList();

        final int limit = 10;
        int counter = 0;

        for (Person person : people) {
            if (person.getAge() <= 18) {
                youngPeople.add(person);
                counter++;
                if (counter == limit) {
                    break;
                }
            }
        }

        for (Person young : youngPeople) {
            System.out.println(young);
        }
    }

    @Test
    public void declarativeApproachUsingStream() throws IOException {
        MockData.getPeople().stream()
                .filter(person -> person.getAge() <= 18)
                .limit(10)
                .toList()
                .forEach(System.out::println);
    }

}
