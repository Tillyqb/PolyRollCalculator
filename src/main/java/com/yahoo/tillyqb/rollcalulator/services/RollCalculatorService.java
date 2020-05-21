package com.yahoo.tillyqb.rollcalulator.services;

import com.yahoo.tillyqb.rollcalulator.constants.MathConstants;
import org.springframework.stereotype.Service;

@Service
public class RollCalculatorService
{
    public Integer calculateRollLength(Double rollOD, Double coreOD, Double thickness)
    {
        Double difference = getRollRadiusSquared(rollOD) - getRollRadiusSquared(coreOD);
        return (int) (difference * MathConstants.PI / thickness);
    }

    private Double getRollRadiusSquared(Double diameter)
    {
        Double radius = diameter / 2;
        return radius * radius;
    }
}
