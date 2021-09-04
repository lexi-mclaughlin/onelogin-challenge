package com.oneloginchallenge;

import com.oneloginchallenge.exceptions.InvalidInputException;
import com.oneloginchallenge.exceptions.ZeroDenominatorException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type quit to exit");

        String input = getNextLine(scanner);

        while (!input.equals("quit") ) {
            String[]  operation = input.trim().split("\\s+");
            if (operation.length != 3){
                System.out.println("Invalid input. Please give two fractions and an operand separated by spaces such as: 1/2 * 3_3/4");
                input = getNextLine(scanner);
                continue;
            }

            Fraction first;
            Fraction second;
            try {
                first = FractionParser.parse(operation[0]);
                second = FractionParser.parse(operation[2]);
            } catch (InvalidInputException e){
                System.out.println("Fractions must in the following format: 3_3/4");
                input = getNextLine(scanner);
                continue;
            } catch (ZeroDenominatorException e) {
                System.out.println("Fractions must have a non zero denominator");
                input = getNextLine(scanner);
                continue;
            }

            Fraction ans = null;
            String operand = operation[1];
            switch(operand){
                case "+":
                    ans = first.add(second);
                    break;
                case "-":
                    ans = first.subtract(second);
                    break;
                case "*":
                    ans = first.multiply(second);
                    break;
                case "/":
                    ans = first.divide(second);
                    break;
            }

            if (ans == null){
                System.out.println("Invalid operand. Valid operands are +, -, * and /");
                input = getNextLine(scanner);
                continue;
            }

            System.out.println("= " + ans);
            input = getNextLine(scanner);
        }
    }

    private static String getNextLine(Scanner scanner){
        System.out.print("? ");
        return scanner.nextLine();
    }
}
