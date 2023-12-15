package io.amit.old.by_online.lambda;

public class TraditionalWay implements Calculator{
    @Override
    public void switchOn() {
        System.out.println("traditional way");
    }

    public static void main(String[] args) {
        TraditionalWay traditionalWay = new TraditionalWay();
        traditionalWay.switchOn();
    }
}
