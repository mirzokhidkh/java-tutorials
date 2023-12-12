package com.mk.concurrency.throughput;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WordCountHandler implements HttpHandler {
    private String text;

    public WordCountHandler(String text) {
        this.text = text;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        String[] keyValue = query.split("=");
        String action = keyValue[0];
        String word = keyValue[1];

        if (!action.equals("word")) {
            exchange.sendResponseHeaders(400, 0);
            return;
        }

        long count = countWord(word);

        byte[] response = Long.toString(count).getBytes();
        exchange.sendResponseHeaders(200, response.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response);
        outputStream.close();
    }

    private long countWord(String word) {
        long count = 0;
        int i = 0;
        while (i >= 0) {
            i = text.indexOf(word, i);

            if (i >= 0) {
                count++;
                i++;
            }
        }
        return count;
    }
}
