package com.mk.concurrency;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


public class Test {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new ThreadGroup("abdi"),() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("in Thread");
        });
        thread.start();
        thread.join(10000);


        System.out.println("SS");


    }


}
