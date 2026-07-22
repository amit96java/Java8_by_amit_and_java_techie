package io.amit.accenture.jee_assessment.core_playground;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            int a[] = new int[1];
            a[1] = 30/0;
            a[2] = 50;
        } catch (ArithmeticException e) {
            System.out.println("Exception 1");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception 2");
        } catch (Exception e) {
            System.out.println("common");
        }
        System.out.println("rest");
    }
}
