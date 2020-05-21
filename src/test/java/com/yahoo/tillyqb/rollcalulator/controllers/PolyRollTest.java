package com.yahoo.tillyqb.rollcalulator.controllers;

import com.yahoo.tillyqb.rollcalulator.services.RollCalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PolyRollTest
{
    @Mock
    private RollCalculatorService rollCalculatorService;
    private PolyRollController polyRollController;

    @Before
    public void setup()
    {
        polyRollController = new PolyRollController(rollCalculatorService);
    }

    @Test
    public void testGetRollLengthCallsRollServiceProperly()
    {
        polyRollController.getRollLength(0.5, 7.0, 12.0);

        Mockito.verify(rollCalculatorService).calculateRollLength(12.0, 7.0, 0.5);
    }
}
