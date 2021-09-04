package com.oneloginchallenge;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FractionUnitTests {
    private Fraction oneHalf;
    private Fraction oneFourth;
    private Fraction one;
    private Fraction twoThirds;
    private Fraction twoNinths;
    private Fraction negativeOneFourth;
    private Fraction negativeOneHalf;

    @Before
    public void setup(){
        oneHalf = new Fraction(1, 2);
        negativeOneHalf = new Fraction(-1, 2);
        oneFourth = new Fraction(1, 4);
        negativeOneFourth = new Fraction(-1, 4);
        one = new Fraction(1, 1);
        twoThirds = new Fraction(2,3);
        twoNinths = new Fraction(2,9);
    }


    @Test
    public void testAdd(){
        Fraction result = oneHalf.add(oneHalf);
        assertEquals(one, result);
    }

    @Test
    public void testAdd_reducesCorrectly(){
        Fraction result = twoNinths.add(twoThirds);
        assertEquals(new Fraction(8, 9), result);
    }

    @Test
    public void testAdd_oneNegative(){
        Fraction result = oneHalf.add(negativeOneFourth);
        assertEquals(oneFourth, result);
    }

    @Test
    public void testAdd_twoNegatives(){
        Fraction result = negativeOneFourth.add(negativeOneFourth);
        assertEquals(negativeOneHalf, result);
    }

    @Test
    public void testSubtract(){
        Fraction result = oneHalf.subtract(oneFourth);
        assertEquals(oneFourth, result);
    }

    @Test
    public void testSubtract_reducesCorrectly(){
        Fraction result = twoThirds.subtract(twoNinths);
        assertEquals(new Fraction(4, 9), result);
    }

    @Test
    public void testSubtract_negativeResult(){
        Fraction result = oneFourth.subtract(oneHalf);
        assertEquals(-1, result.numerator);
        assertEquals(4, result.denominator);
    }

    @Test
    public void testSubtract_negativeNumbers(){
        Fraction result = oneHalf.subtract(negativeOneFourth);
        assertEquals(new Fraction(3, 4), result);
    }

    @Test
    public void testSubtract_equalsZero(){
        Fraction result = oneHalf.subtract(oneHalf);
        assertEquals(0, result.numerator);
    }

    @Test
    public void testMultiply(){
        Fraction result = oneHalf.multiply(oneHalf);
        assertEquals(oneFourth, result);
    }

    @Test
    public void testMultiply_oneNegative(){
        Fraction result = negativeOneFourth.multiply(oneFourth);
        assertEquals(new Fraction(-1, 16), result);
    }

    @Test
    public void testMultiply_twoNegatives(){
        Fraction result = negativeOneFourth.multiply(negativeOneFourth);
        assertEquals(new Fraction(1, 16), result);
    }

    @Test
    public void testMultiply_reducesCorrectly(){
        Fraction result = twoThirds.multiply(oneHalf);
        assertEquals(new Fraction(1, 3), result);
    }

    @Test
    public void testMultiply_oneWholeNumber(){
        Fraction result = twoThirds.multiply(one);
        assertEquals(twoThirds, result);
    }

    @Test
    public void testDivide(){
        Fraction result = oneFourth.divide(oneHalf);
        assertEquals(oneHalf, result);
    }

    @Test
    public void testDivide_oneNegative(){
        Fraction result = negativeOneFourth.divide(oneHalf);
        assertEquals(negativeOneHalf, result);
    }

    @Test
    public void testDivide_twoNegatives(){
        Fraction result = negativeOneFourth.divide(negativeOneFourth);
        assertEquals(one, result);
    }

    @Test
    public void testDivide_reducesCorrectly(){
        Fraction result = twoNinths.divide(twoThirds);
        assertEquals(new Fraction(1, 3), result);
    }

    @Test
    public void testDivide_equalsWholeNumber(){
        Fraction result = oneHalf.divide(oneHalf);
        assertEquals(one, result);
    }

}
