package com.ocp21.chapter4;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
//        System.out.println("asdf".substring(0, 4));

        MyObject myObject = new MyObject();
        myObject.code = 11;
        myObject.name = "s";


        System.out.println("sss" + myObject.toString());


        String str0 = """
                a
                 b
                c""";

        var str = " a\n"
                + "  b\n"
                + " c";


        System.out.println(str);
        System.out.println(str.length());
        System.out.println(str.indent(-1).length());

        System.out.println(str.stripIndent());

        StringBuilder stringBuilder = new StringBuilder();

        var stringBuilder1 = new StringBuilder();


        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());


    }
}
