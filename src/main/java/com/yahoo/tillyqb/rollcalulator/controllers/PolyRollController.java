package com.yahoo.tillyqb.rollcalulator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polycalculator")
public class PolyRollController {
    @GetMapping
    public Integer getRollLength(@RequestParam Double thickness, @RequestParam Double coreOD, @RequestParam Double rollOD)
    {
        Integer rollLength = 0;

        /*rollLength = (int) ((((rollOD * 3.141592654) + (coreOD * 3.141592654)) / 2) * ((rollOD - coreOD) / thickness));*/
        rollOD/=2;
        rollOD*=rollOD;

        coreOD/=2;
        coreOD*=coreOD;

        rollOD-=coreOD;
        rollOD*=3.14195;

        rollLength = (int) (rollOD/thickness);



        return rollLength;
    }
}
