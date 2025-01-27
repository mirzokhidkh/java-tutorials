package com.mk.parse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        String response2 = "{\n" +
                "\t\"RE\": \"0\",\n" +
                "\t\"operationId\": \"774a0650-0a1f-49ce-b541-27e01ea65d85\",\n" +
                "\t\"responseJson\": {\n" +
                "\t\t\"responseObject\": {\n" +
                "\t\t\t\"processReferenceNo\": 47004033004,\n" +
                "\t\t\t\"externalFirmReferenceNo2\": \"09003-0000000144\",\n" +
                "\t\t\t\"externalFirmReferenceNo\": \"47004033004\",\n" +
                "\t\t\t\"apiAgentTxnRefNo\": \"09003-0000000144\"\n" +
                "\t\t},\n" +
                "\t\t\"header\": {\n" +
                "\t\t\t\"code\": \"1\",\n" +
                "\t\t\t\"success\": true,\n" +
                "\t\t\t\"messageCode\": \"OPERATION_DONE_SUCCESSFUL\",\n" +
                "\t\t\t\"message\": \"OPERATION_DONE_SUCCESSFUL\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";


//        ObjectMapper objectMapper = new ObjectMapper();

//        Object object = objectMapper.readValue(response2, Object.class);
//
///        System.out.println(objectMapper.writeValueAsString(object));

        JSONObject json = null;
        try {
            json = (JSONObject) new JSONParser().parse(response2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject responseJson = (JSONObject) json.get("responseJson");
        JSONObject responseObject =(JSONObject)  responseJson.get("responseObject");

        System.out.println(responseObject.toString());


    }
}
