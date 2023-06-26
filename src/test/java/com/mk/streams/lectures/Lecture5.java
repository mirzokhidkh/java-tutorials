package com.mk.streams.lectures;

import com.mk.streams.beans.Car;
import com.mk.streams.beans.Person;
import com.mk.streams.beans.PersonDTO;
import com.mk.streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Lecture5 {

    @Test
    public void understandingFilter() throws IOException {

        List<Car> cars = MockData.getCars();

        final Predicate<Car> cardPredicate = car -> car.getPrice() < 10000;

        List<Car> carsFiltered = cars.stream()
                .filter(cardPredicate)
                .collect(Collectors.toList());

        carsFiltered.forEach(System.out::println);


    }


    @Test
    public void ourFirstMapping() throws IOException {

        List<Person> people = MockData.getPeople();

        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

        List<PersonDTO> dtos = people.stream()
//                .map(personPersonDTOFunction)
                .map(PersonDTO::map)
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);

        assertThat(dtos).hasSize(1000);
    }


    @Test
    public void averageCarPrice() throws IOException {

        List<Car> cars = MockData.getCars();

        double average = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(average);



    }
}
