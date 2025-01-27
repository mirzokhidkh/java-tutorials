package com.mk.stringTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();
        String bigData = new String(Files.readAllBytes(Paths.get("src/test/java/com/mk/stringTest/Kafka-esb-db-req-json-big.json")));
        System.out.println(bigData);

        System.out.println(bigData.length());
        Object bigDataJson = objectMapper.readValue(bigData, Object.class);



    }
}
