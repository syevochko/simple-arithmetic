package com.google.evochko;

import matchParser.MatchParser;
import org.junit.Assert;

public class CalculationTest extends Assert {
    private static MatchParser calculation = new MatchParser();

    @org.junit.Test
    public void testMultiply() throws Exception {
        assertEquals(3.75, calculation.Parse("1.5*2.5"), 0);
    }

    @org.junit.Test
    public void testMultiOperations() throws Exception {
        assertEquals(-36.55, calculation.Parse("(1.5-2.5)*36.55"), 0);
    }

    @org.junit.Test
    public void testFunctiion() throws Exception {
        calculation.setVariable("x1", 1.5);
        calculation.setVariable("x2", -1.5);
        calculation.setVariable("x3", 5.36);
        assertEquals(0.0, calculation.Parse("(x1+x2)*x3"), 0);
    }
}
