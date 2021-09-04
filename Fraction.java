package com.oneloginchallenge;

public class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator){

        //Make sure the numerator is always the negative number if the fraction is negative
        if (numerator < 0 && denominator < 0){
            this.numerator = Math.abs(numerator);
            this.denominator = Math.abs(denominator);
        } else if (numerator >= 0 && denominator < 0){
            this.numerator = numerator * -1;
            this.denominator = Math.abs(denominator);
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int wholeNum, int numerator, int denominator){
        this(numerator + (wholeNum * denominator), denominator);
    }

    public Fraction add(Fraction fraction){
        int num = (this.numerator * fraction.denominator) + (fraction.numerator * this.denominator);
        int denom = this.denominator * fraction.denominator;

        Fraction result = new Fraction(num, denom);
        return  result.reduce();
    }

    public Fraction subtract(Fraction fraction){
        int num = (numerator * fraction.denominator) - (fraction.numerator * denominator);
        int denom = denominator * fraction.denominator;
        Fraction result = new Fraction(num, denom);
        result.reduce();
        return  result.reduce();
    }

    public Fraction multiply(Fraction fraction){
        int num = numerator * fraction.numerator;
        int denom = denominator * fraction.denominator;
        Fraction result = new Fraction(num, denom);
        return result.reduce();
    }

    public Fraction divide(Fraction fraction) {
        int num = numerator * fraction.denominator;
        int denom = denominator * fraction.numerator;
        Fraction result = new Fraction(num, denom);
        return result.reduce();
    }

    @Override
    public String toString(){
        if (numerator == 0) {
            return "0";
        }
        String s = isNegative()? "-" : "";
        int num = Math.abs(numerator);
        if (num == denominator){
            return s + "1";
        }
        if (num > denominator) {
            int whole = num / denominator;
             num = num % denominator;
            if (num == 0) {
                return s + whole;
            }
            return s + whole + "_" + num + "/" + denominator  ;
        }
        return s + num + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Fraction)){
            return false;
        }
        Fraction fraction = (Fraction) o;
        return denominator == fraction.denominator && numerator == fraction.numerator;
    }

    private Fraction reduce(){
        Integer gcd = this.getGCD();
        if (numerator != 0){
            numerator = numerator / gcd;
        }
        denominator = denominator / gcd;
        return this;
    }

    private int getGCD(){
        if (numerator == 0){
            return denominator;
        }
        int a = Math.abs(numerator);
        int b = denominator;
        while (a != b) {
            if(a > b)
                a = a - b;
            else
                b = b - a;
        }
        return b;
    }

    private boolean isNegative(){
       if (numerator < 0){
           return true;
       }
       return false;
    }
}
