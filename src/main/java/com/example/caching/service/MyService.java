package com.example.caching.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    // Caching the result of this method with the cache name "items"
    @Cacheable(value = "items", key = "#id")
    public String getItemById(String id) {
        // Simulate a time-consuming operation
        try {
            Thread.sleep(3000);  // Simulating delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Item with ID: " + id;
    }
}
