package com.yahoo.tillyqb.rollcalulator.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.web.server.ResponseStatusException;

public class RollCaclulatorTest
{
    @Rule
    public ExpectedException exceptionChecker = ExpectedException.none();
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

    @Test
    public void testGetRollLengthThrowsErrorWhenCoreODExceedsRollOD()
    {
        exceptionChecker.expect(ResponseStatusException.class);
        exceptionChecker.expectMessage("coreOD cannot exceed rollOD");
        testController.calculateRollLength(1.0,500.0,0.12345);
    }
}
