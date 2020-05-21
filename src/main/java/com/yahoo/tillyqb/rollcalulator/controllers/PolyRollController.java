package com.yahoo.tillyqb.rollcalulator.controllers;

import com.yahoo.tillyqb.rollcalulator.services.RollCalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polycalculator")
@AllArgsConstructor
public class PolyRollController
{
    private RollCalculatorService rollCalculatorService;

    @GetMapping
    public Integer getRollLength(@RequestParam Double thickness, @RequestParam Double coreOD, @RequestParam Double rollOD)
    {
        return rollCalculatorService.calculateRollLength(rollOD, coreOD, thickness);
    }
}
