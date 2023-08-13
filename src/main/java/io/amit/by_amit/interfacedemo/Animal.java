package io.amit.by_amit.interfacedemo;

public class Animal{
    private String legs ;
    private String wings;

    public Animal(String legs, String wings) {
        this.legs = legs;
        this.wings = wings;
    }


    public void show(Behavior behavior) {
        System.out.println("legs "+legs+" wings "+wings);
        behavior.walk(legs, wings);
    }

    public static void main(String[] args) {
        new Animal("2", "2").show((legs, wings) -> System.out.println("walk........"+legs+ " -----> "+wings));
    }

}
