package com.ocp21.chapter4;

import org.apache.log4j.net.JMSSink;

import java.time.*;

public class DateExample {
    public static void main(String[] args) {
        var localDate = LocalDate.of(2025, Month.AUGUST, 2);
        System.out.println(localDate);
        localDate = localDate.plusDays(1);
        System.out.println(localDate);



        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        System.out.println(localDateTime.plusMinutes(0));

        System.out.println(Period.ofMonths(3));

        LocalDate localDate1 = LocalDate.of(2000, Month.AUGUST, 19);
        LocalTime localTime = LocalTime.of(8, 40);



        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1, localTime);

        System.out.println(localDateTime1);

        Duration duration = Duration.ofHours(25);

        System.out.println(localDateTime1.plus(duration));


    }

}
