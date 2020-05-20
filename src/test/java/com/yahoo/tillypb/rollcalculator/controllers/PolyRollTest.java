package com.yahoo.tillypb.rollcalculator.controllers;

import com.yahoo.tillyqb.rollcalulator.controllers.PolyRollController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolyRollTest
{
    private PolyRollController testController;

    @Before
    public void setup()
    {
        testController = new PolyRollController();
    }

    @Test
    public void testGetRollLength()
    {
        Integer actual = testController.getRollLength(.0045, 3.625, 25.125);
        Integer expected = 107895;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRollLengthAlternateValues()
    {
        Integer actual = testController.getRollLength(.0060, 6.625, 21.8);
        Integer expected = 56469;

        Assert.assertEquals(expected, actual);
    }
}
