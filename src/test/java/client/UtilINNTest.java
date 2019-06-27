package client;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilINNTest {

    @Test
    public void checkNumberTrue() {
        assertTrue(UtilINN.checkNumber("1234567890"));
    }

    @Test
    public void checkNumberFalse() {
        assertFalse(UtilINN.checkNumber("1234567890as"));
    }

    @Test
    public void checkLengthTrue() {
        assertTrue(UtilINN.checkLength("1234567890"));
        assertTrue(UtilINN.checkLength("123456789012"));
    }

    @Test
    public void checkLengthFalse() {
        assertFalse(UtilINN.checkLength("123456789"));
        assertFalse(UtilINN.checkLength("12345678901"));
        assertFalse(UtilINN.checkLength("1234567890123"));
    }
}