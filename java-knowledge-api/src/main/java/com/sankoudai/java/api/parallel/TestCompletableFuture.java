package com.sankoudai.java.api.parallel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import static java.util.concurrent.Executors.*;

/**
 * QS 过滤字段
 *
 * @author sankoudai
 */
public class TestCompletableFuture {
    private ExecutorService executor = null;

    public void init() {
        executor = newFixedThreadPool(1);
    }

    public <T> CompletableFuture<T> submitTask(Supplier<T> task) {
        return CompletableFuture.supplyAsync(task, executor);
    }

    public Map<String, String> test1() {
        return new HashMap<>();
    }
    public void testSupplier() {
        CompletableFuture<Map<String, String>> a = submitTask(()->{
            int i =1;
            return test1();
        });
    }
}
