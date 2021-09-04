package com.oneloginchallenge;

import com.oneloginchallenge.exceptions.InvalidInputException;
import com.oneloginchallenge.exceptions.ZeroDenominatorException;

public class FractionParser {

    public static Fraction parse(String input){
        String wholeNumber = input.split("_")[0];
        String[] fraction = input.split("_|/");
        if (fraction.length == 3) {
            int whole = Integer.parseInt(wholeNumber);
            int num = Integer.parseInt(fraction[1]);
            int denom  = Integer.parseInt(fraction[2]);
            checkNonZeroDenom(denom);
            return new Fraction(whole, num, denom);
        } else if (fraction.length == 2) {
            int num = Integer.parseInt(fraction[0]);
            int denom  = Integer.parseInt(fraction[1]);
            checkNonZeroDenom(denom);
            return new Fraction(num, denom);
        }else if (fraction.length == 1) {
            int whole = Integer.parseInt(fraction[0]);
            return new Fraction(whole, 1);
        } else {
            throw new InvalidInputException();
        }
    }

    private static void checkNonZeroDenom(int denom){
        if (denom == 0){
            throw new ZeroDenominatorException();
        }
    }
}
