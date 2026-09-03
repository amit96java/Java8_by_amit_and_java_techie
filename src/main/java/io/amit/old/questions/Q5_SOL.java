package io.amit.old.questions;


/**
 *
 * Liskov Substitution Principle
 *
 * Subtypes must be substitutable for their base types without altering the
 * correctness of the program.
 */


// Issue: Ostrich can not fly but child class ABird enforcing to implement fly() method.

class ABird {
    public void fly() {
        System.out.println("Flying");
    }
}

class Sparrow extends ABird {
    // Sparrow can fly
}

class Ostrich extends ABird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}

// Solution: Use Flyable interface with  Sparrow and not use with Ostrich

abstract class Bird {
    abstract void move();
}

interface Flyable {
    void fly();
}

class Sparrow1 extends Bird implements Flyable {

    @Override
    public void move() {
        System.out.println("Sparrow is moving");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich1 extends Bird {

    @Override
    public void move() {
        System.out.println("Ostrich is walking");
    }
}




public class Q5_SOL {
}
