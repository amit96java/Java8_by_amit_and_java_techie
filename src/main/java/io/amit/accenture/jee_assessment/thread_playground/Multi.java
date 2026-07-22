package io.amit.accenture.jee_assessment.thread_playground;

public class Multi extends Thread{
    public void run() {
        System.out.println("running");
    }

    public static void main(String[] args) {
        Multi t1 = new Multi();
        t1.run();
    }
}
