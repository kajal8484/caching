package com.example.caching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.caching.service.MyService;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/item")
    public String getItem(@RequestParam String id) {
        return myService.getItemById(id);
    }
}
