package com.example.androidassignment;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuffixerTest {

    @Test
    public void testValidGetSuffix() {
        Suffixer suffix = new Suffixer("Test", 1);
        try {
            String result = suffix.getSuffix();
            assertEquals(result, "est");
        } catch (Exception e) {
            return;
        }
    }

    @Test
    public void testInvalidGetSuffix() {
//      Test index smaller than 0
        String input = "Test";
        Suffixer suffix = new Suffixer(input, -1);
        try {
            String result = suffix.getSuffix();
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Index should be greater than 0 and smaller than " + (input.length() - 1));
        }

//      Test index greater than length of input
        input = "Testing";
        suffix = new Suffixer(input, 9);
        try {
            String result = suffix.getSuffix();
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Index should be greater than 0 and smaller than " + (input.length() - 1));
        }
    }


}
