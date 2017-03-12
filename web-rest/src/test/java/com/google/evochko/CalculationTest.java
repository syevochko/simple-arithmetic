package com.google.evochko;

import junit.framework.Assert;
import matchParser.MatchParser;
import org.junit.Test;

public class CalculationTest {
    private static MatchParser calculation = new MatchParser();

    @Test
    public void testMultiply() throws Exception {
        Assert.assertEquals(3.75, calculation.Parse("1.5*2.5"));
    }

    @Test
    public void testMultiOperations() throws Exception {
        Assert.assertEquals(-36.55, calculation.Parse("(1.5-2.5)*36.55"));
    }

    @Test
    public void testFunctiion() throws Exception {
        calculation.setVariable("x1", 1.5);
        calculation.setVariable("x2", -1.5);
        calculation.setVariable("x3", 5.36);
        Assert.assertEquals(0.0, calculation.Parse("(x1+x2)*x3"));
    }
}
