package com.yahoo.tillyqb.rollcalulator.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RollCaclulatorTest
{
    private RollCalculatorService testController;

    @Before
    public void setup()
    {
        testController = new RollCalculatorService();
    }

    @Test
    public void testGetRollLength()
    {
        Integer actual = testController.calculateRollLength(25.125, 3.625, .0045);
        Integer expected = 107879;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRollLengthAlternateValues()
    {
        Integer actual = testController.calculateRollLength(21.8, 6.625, .0060);
        Integer expected = 56461;

        Assert.assertEquals(expected, actual);
    }
}
