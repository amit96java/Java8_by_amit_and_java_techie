package io.amit.old.by_online.lambda;

public class AsFunctionalInterface {

    public static void main(String[] args) {
        Calculator calculator = () -> {
            System.out.println("AsFunctional interface way...");
        };
        calculator.switchOn();
        /*************************************************************/

        CalculatorWithParam calculatorWithParam = (input) -> {
            System.out.println("Sum is " + input);
        };

        calculatorWithParam.sum(5);
        /**********************************************************/

        CalculatorWithReturnType calculatorWithReturnType = (num1, num2) -> num1 + num2;

        System.out.println("return sum is " + calculatorWithReturnType.sum(4, 4));
    }
}
