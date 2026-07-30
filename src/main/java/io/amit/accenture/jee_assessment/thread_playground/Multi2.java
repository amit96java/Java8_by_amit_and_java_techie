package io.amit.accenture.jee_assessment.thread_playground;

public class Multi2 extends Thread{
    public void run() {
        System.out.println("running...");
    }

    public static void main(String[] args) {
        Multi2 t = new Multi2();
        t.start();
        t.start(); //IllegalThreadStateException
    }
}
