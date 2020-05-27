package com.yahoo.tillyqb.rollcalulator.services;

import com.yahoo.tillyqb.rollcalulator.constants.MathConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RollCalculatorService
{
    public Integer calculateRollLength(Double rollOD, Double coreOD, Double thickness)
    {
        if (coreOD > rollOD) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "coreOD cannot exceed rollOD");
        Double difference = getRollRadiusSquared(rollOD) - getRollRadiusSquared(coreOD);
        return (int) (difference * MathConstants.PI / thickness);
    }

    private Double getRollRadiusSquared(Double diameter)
    {
        Double radius = diameter / 2;
        return radius * radius;
    }
}
