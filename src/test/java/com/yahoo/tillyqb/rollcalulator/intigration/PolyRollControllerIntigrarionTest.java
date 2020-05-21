package com.yahoo.tillyqb.rollcalulator.intigration;

import com.yahoo.tillyqb.rollcalulator.services.RollCalculatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PolyRollControllerIntigrarionTest
{
    @Autowired
    private MockMvc mvc;
    @Autowired
    private RollCalculatorService rollCalculatorService;

    @Test
    public void returnsHttpOkOnValidRequest() throws Exception
    {
        String response = mvc.perform(MockMvcRequestBuilders.get("/polycalculator?thickness=0.5&coreOD=50&rollOD=78")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        int expectedResponse = rollCalculatorService.calculateRollLength(78.0, 50.0, 0.5);

        Assert.assertEquals(expectedResponse, Integer.parseInt(response));
    }

    @Test
    public void returnHttpBadRequestWhenThicknessIsANonnumericValue() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/polycalculator?thickness=tron&coreOD=900&rollOD=23")).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
