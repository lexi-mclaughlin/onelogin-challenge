package com.oneloginchallenge;

import com.oneloginchallenge.exceptions.ZeroDenominatorException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FractionParserUnitTests {

    @Test
    public void testReadsFraction(){
        Fraction result = FractionParser.parse("1/2");
        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    public void testReadsFractionAndWholeNumber(){
        Fraction result = FractionParser.parse("1_1/2");
        assertEquals(new Fraction(3, 2), result);
    }

    @Test
    public void testReadsNegativeFraction(){
        Fraction result = FractionParser.parse("-1/2");
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    public void testReadsDoubleNegativeFraction(){
        Fraction result = FractionParser.parse("-1/-2");
        System.out.println(result.numerator);
        System.out.println(result.denominator);

        assertEquals(new Fraction(1, 2), result);
    }

    @Test
    public void testReadsTripleNegativeFraction(){
        Fraction result = FractionParser.parse("-1_-1/-2");
        assertEquals(new Fraction(-1, 2), result);
    }

    @Test
    public void testThrowsExceptionOnNonIntegers(){
        assertThrows(RuntimeException.class,
                () -> FractionParser.parse("a_1/2"));
    }

    @Test
    public void testThrowsExceptionOnZeroDenominator(){
        assertThrows(ZeroDenominatorException.class,
                () -> FractionParser.parse("1/0"));
    }

    @Test
    public void testThrowsExceptionOnWrongFormat(){
        assertThrows(RuntimeException.class,
                () -> FractionParser.parse("1/4_3"));
    }
}
