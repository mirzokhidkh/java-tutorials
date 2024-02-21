package com.mk.concurrency;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


public class Test {
    public static void main(String[] args) {
//        int a = 1;
//        doSomething(a);
//        a+=1;
//        System.out.println(a);


//        String str = "{\n" +
//                "  \"exception\": \"\",\n" +
//                "  \"RE\": \"40000\",\n" +
//                "  \"resultCode\": \"3\",\n" +
//                "  \"ERR_TEXT\": \"\",\n" +
//                "  \"mainObject\": {},\n" +
//                "  \"fault\": {\n" +
//                "    \"faultCode\": \"xrsi:error-reply\",\n" +
//                "    \"faultString\": \"business exception\",\n" +
//                "    \"errors\": [\n" +
//                "      {\n" +
//                "        \"code\": \"S00009\",\n" +
//                "        \"message\": \"Transaction is paid\"\n" +
//                "      }\n" +
//                "    ]\n" +
//                "  }\n" +
//                "}";
//        JSONObject jsonObject = new JSONObject(str);
//        JSONObject fault = jsonObject.getJSONObject("fault");
//        Object o = fault.get("faultCode");
//        System.out.println(o);
//        JSONArray errors = fault.getJSONArray("errors");
//        JSONObject errorItem = errors.getJSONObject(0);
//        System.out.println(errorItem.get("code"));
//
//        Object o1 = jsonObject.getJSONObject("fault").getJSONArray("errors").getJSONObject(0).get("message");
//        System.out.println(o1);


//        Random random = new Random();
//        int i = 10000 + random.nextInt(100000);
//        System.out.println(i);

//        String queryIdStr = String.valueOf(UUID.randomUUID());
//        System.out.println(queryIdStr.substring(0,14).length());

//        LocalDate now = LocalDate.now();
//        System.out.println(now.toString());


//        String[] accounts = new String[]{"22618000799000004001", "16549000500000440104", "56602000200000440143",
//                "16101840900000398001","23504000300000399510","14901000799001856001"
//        };
//
//        System.out.println(accounts[random.nextInt(accounts.length)]);

//        String hello = PasswordEncoder.encode("hello");
//        System.out.println(hello);
        System.out.println("@".matches("[^A-Za-z0-9]"));

//        String  line  = "........................................................862...........20";
//        System.out.println(line.length());
//        System.out.println(line.indexOf("0"));


    }

    public static void doSomething(int a) {
        a += 1;
    }
}
