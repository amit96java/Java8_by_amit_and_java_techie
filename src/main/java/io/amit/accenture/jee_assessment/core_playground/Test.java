package io.amit.accenture.jee_assessment.core_playground;

public class Test {
    public static void show() {
        System.out.println("show");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            System.out.println("Hi");
            show();
        } catch (Exception e) {
            System.out.println("caught");
        } finally {
            System.out.println("finally");
        }
        System.out.println("Last");
    }
}
