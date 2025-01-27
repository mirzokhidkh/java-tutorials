package com.mk.timeApi;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Date date = new Date(new java.util.Date().getTime());
        System.out.println(date.toLocalDate());

        long timeMillis = System.currentTimeMillis();

//        System.out.println(timeMillis);
//
//        date.setTime(timeMillis);
//
//        System.out.println(date.toLocalDate());

        Timestamp timestamp = new Timestamp(timeMillis);
        System.out.println(timestamp);


        System.out.println();

        Calendar calendar = Calendar.getInstance();

        // Set the date you want to modify
        calendar.setTime(new Date(timeMillis));

        // Add time (for example, adding 1 hour)
        calendar.add(Calendar.HOUR_OF_DAY, 1);

        // Get the modified date
        Date modifiedDate = (Date) calendar.getTime();

        System.out.println("Original date: " + new Date(timeMillis));
        System.out.println("Modified date: "
                + modifiedDate);

    }
}
