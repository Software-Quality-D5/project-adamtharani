package com.ontariotechu.sofe3980U;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor() {
        Binary binary = new Binary("1001001");
        assertEquals("1001001", binary.getValue());
    }

    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits() {
        Binary binary = new Binary("1001001211");
        assertEquals("0", binary.getValue());
    }

    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars() {
        Binary binary = new Binary("1001001A");
        assertEquals("0", binary.getValue());
    }

    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign() {
        Binary binary = new Binary("-1001001");
        assertEquals("0", binary.getValue());
    }

    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing() {
        Binary binary = new Binary("00001001");
        assertEquals("1001", binary.getValue());
    }

    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString() {
        Binary binary = new Binary("");
        assertEquals("0", binary.getValue());
    }

    /**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertEquals("10111", binary3.getValue());
    }

    /**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertEquals("1101", binary3.getValue());
    }

    /**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertEquals("1101", binary3.getValue());
    }

    /**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertEquals("1010", binary3.getValue());
    }

    /**
     * Test The add functions with two zeros
     */
    @Test
    public void add5() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertEquals("0", binary3.getValue());
    }

    /**
     * Test the or function with two binary numbers of the same length
     */
    @Test
    public void or() {
        Binary binary1 = new Binary("10011010");
        Binary binary2 = new Binary("01000110");
        Binary binary3 = Binary.or(binary1, binary2);
        assertEquals("11011110", binary3.getValue());
    }

    /**
     * Test the or function with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void or2() {
        Binary binary1 = new Binary("010001");
        Binary binary2 = new Binary("10011010");
        Binary binary3 = Binary.or(binary1, binary2);
        assertEquals("10011011", binary3.getValue());
    }

    /**
     * Test the or function with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void or3() {
        Binary binary1 = new Binary("1100101010");
        Binary binary2 = new Binary("00110100");
        Binary binary3 = Binary.or(binary1, binary2);
        assertEquals("1100111110", binary3.getValue());
    }

    /**
     * Test the or function with a binary numbers with zero
     */
    @Test
    public void or4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.or(binary1, binary2);
        assertEquals("1010", binary3.getValue());
    }

    /**
     * Test the and function with two binary numbers of the same length
     */
    @Test
    public void and() {
        Binary binary1 = new Binary("10011010");
        Binary binary2 = new Binary("01000110");
        Binary binary3 = Binary.and(binary1, binary2);
        assertEquals("00000010", binary3.getValue());
    }

    /**
     * Test the and function with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void and2() {
        Binary binary1 = new Binary("010001");
        Binary binary2 = new Binary("10011010");
        Binary binary3 = Binary.and(binary1, binary2);
        assertEquals("00010000", binary3.getValue());
    }

    /**
     * Test the and function with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void and3() {
        Binary binary1 = new Binary("1100101010");
        Binary binary2 = new Binary("00110100");
        Binary binary3 = Binary.and(binary1, binary2);
        assertEquals("0000100000", binary3.getValue());
    }
}
