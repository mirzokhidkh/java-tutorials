package com.mk.reflection;

//import com.fasterxml.jackson.databind.ObjectMapper;

//import java.util.Map;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
//        Example example = new Example("John", 30);
////        ObjectMapper objectMapper = new ObjectMapper();
////        Object object = objectMapper.convertValue(example, Object.class);
//        Object object = example;
//        Map<String, Object> fieldMap = ReflectionUtil.getCustomFieldNamesAndValues(object);
//
//        fieldMap.forEach((key, value) ->
//                System.out.println("Field: " + key + ", Value: " + value)
//        );


        System.out.println("HELLOO");

//        System.out.println(args[0]);
        Arrays.stream(args).forEach(System.out::println);
    }
}


