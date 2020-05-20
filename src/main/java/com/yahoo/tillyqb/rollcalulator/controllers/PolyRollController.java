package com.yahoo.tillyqb.rollcalulator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polycalculator")
public class PolyRollController {
    @GetMapping
    public Integer getRollLength(@RequestParam Double thickness, @RequestParam Double coreOD, @RequestParam Double rollOD, @RequestParam Double pi)
    {
        Integer rollLength = 0;
        pi = 3.141592654;
        rollOD/=2;
        rollOD*=rollOD;

        coreOD/=2;
        coreOD*=coreOD;

        rollOD-=coreOD;
        rollOD*=pi;

        rollLength = (int) (rollOD/thickness);



        return rollLength;
    }
}
