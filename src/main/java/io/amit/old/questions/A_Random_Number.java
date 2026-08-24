package io.amit.old.questions;

import java.util.Random;

public class A_Random_Number {

        public static void main(String[] args) {
            Random random = new Random();

            int number = random.nextInt(12) + 1;

            System.out.println("Random Number: " + number);
        }

}
