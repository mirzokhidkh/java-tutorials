package com.ocp21.chapter13_Concurrency.concurrentCollectin;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        var foodData = new HashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet())
            foodData.remove(key);

    }
}
