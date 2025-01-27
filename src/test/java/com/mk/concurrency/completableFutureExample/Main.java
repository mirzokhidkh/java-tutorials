package com.mk.concurrency.completableFutureExample;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1); // Adjust the pool size as needed
        DaoCallable daoCallable = new DaoCallable();

        Future<Boolean> future = executorService.submit(daoCallable);

        try {
            Boolean b = future.get(5000, TimeUnit.MILLISECONDS);
            System.out.println(b);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {

            System.out.println("TIME OUT");
        }



    }
}
