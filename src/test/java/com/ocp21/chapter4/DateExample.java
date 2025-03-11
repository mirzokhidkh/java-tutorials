package com.ocp21.chapter4;

import org.apache.log4j.net.JMSSink;

import java.time.*;

public class DateExample {
    public static void main(String[] args) {
        var localDate = LocalDate.of(2025, Month.AUGUST, 2);
        System.out.println(localDate);
        localDate = localDate.plusDays(1);
        System.out.println(localDate);



        var localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        System.out.println(localDateTime.plusMinutes(0));

        System.out.println(Period.ofMonths(23));

        var localDate1 = LocalDate.of(2025, Month.JANUARY, 20);
        var localTime = LocalTime.of(6, 15);



        var localDateTime1 = LocalDateTime.of(localDate1, localTime);

        System.out.println(localDateTime1);

        Duration duration = Duration.ofHours(23);
        System.out.println(localDateTime1.plus(duration));


        duration = Duration.ofDays(1);
        System.out.println(localDate1.plus(duration));


    }

}
