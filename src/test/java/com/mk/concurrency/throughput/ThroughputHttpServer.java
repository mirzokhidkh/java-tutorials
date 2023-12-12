package com.mk.concurrency.throughput;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThroughputHttpServer {
    private static final String INPUT_FILE = "src/test/resources/throughput/war_and_peace.txt";
    private static final int NUMBER_OF_THREADS= 1;
    public static void main(String[] args) throws IOException {

        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
        //then test on briwserhttp://localhost:8000/search?word=talk
    }

    private static void startServer(String text) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        httpServer.createContext("/search",new WordCountHandler(text));
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        httpServer.setExecutor(executor);
        httpServer.start();
    }
}
