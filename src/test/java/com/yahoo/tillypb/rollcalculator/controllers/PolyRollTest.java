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
        Integer actual = testController.getRollLength(4.5, 3.625, 25.125);
        Integer expected = 9000;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRollLengthAlternateValues()
    {
        Integer actual = testController.getRollLength(6.0, 6.625, 21.8);
        Integer expected = 4500;

        Assert.assertEquals(expected, actual);
    }
}
