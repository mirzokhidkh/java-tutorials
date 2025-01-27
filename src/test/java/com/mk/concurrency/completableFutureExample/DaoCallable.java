package com.mk.concurrency.completableFutureExample;

import java.util.concurrent.Callable;

public class DaoCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        Thread.sleep(10000);
        return true;
    }
}
