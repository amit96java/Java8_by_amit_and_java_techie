package io.amit.accenture.jee_assessment.core_playground;

public class Test2 {
    public static void main(String[] args) throws Exception {
        try {
            int i = 5/0;
        } catch (Exception e) {
            throw new Exception();
        } finally {
            System.out.println("finally");
        }
    }
}
