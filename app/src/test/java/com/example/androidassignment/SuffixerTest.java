package com.example.androidassignment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class SuffixerTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testValidGetSuffix() {
        Suffixer suffix = new Suffixer("Test", "1");
        try {
            String result = suffix.getSuffix();
            assertEquals(result, "est");
        } catch (Exception e) {
            return;
        }
    }

    @Test
    public void testInvalidSecondParameter() {
        Suffixer suffix = new Suffixer("Test", "invalidIndex");
        try {
            String result = suffix.getSuffix();
            exceptionRule.expect(NumberFormatException.class);
            exceptionRule.expectMessage("Please enter a valid index number");
        } catch (Exception e) {
        }
    }

    @Test
    public void testInvalidGetSuffix() {
//      Test index smaller than 0
        String input = "Test";
        Suffixer suffix = new Suffixer(input, "-1");
        try {
            String result = suffix.getSuffix();
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Index should be greater than 0 and smaller than " + (input.length() - 1));
        }

//      Test index greater than length of input
        input = "Testing";
        suffix = new Suffixer(input, "7");
        try {
            String result = suffix.getSuffix();
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Index should be greater than 0 and smaller than " + (input.length() - 1));
        }
    }


}
