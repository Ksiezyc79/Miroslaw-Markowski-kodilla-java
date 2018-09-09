package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        int addResult = calculator.add(7, 7);
        int subtractionResult = calculator.subtraction(7, 5);

        if ((addResult == 14) && (subtractionResult == 2)) {
            System.out.println("class Calculator OK");
        } else {
            System.out.println("class Calculator error");
        }
    }
}
