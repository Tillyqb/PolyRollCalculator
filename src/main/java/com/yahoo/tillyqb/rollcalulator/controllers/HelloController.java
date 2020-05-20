package com.yahoo.tillyqb.rollcalulator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/hello/{name}")
    public String getMoringGrettings(@PathVariable String name)
    {
        return "Hello " + name;
    }
}
