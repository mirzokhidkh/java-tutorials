package com.ocp21.chapter11.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        LocalTime localTime = LocalTime.of(12, 34, 56);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'y'y' hh:mm:ss");
//        System.out.println(localDate.format(formatter));
        System.out.println(localDateTime.format(formatter));
    }
}
