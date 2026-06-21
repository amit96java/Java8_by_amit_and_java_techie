package io.amit.old.questions;


/**
 * Subtypes must be substitutable for their base types without altering the
 * correctness of the program.
 */



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

// Better approach
abstract class Bird {
    abstract void move();
}

class FlyingBird extends Bird {
    public void move() {
        System.out.println("Flying");
    }
}

class NonFlyingBird extends Bird {
    public void move() {
        System.out.println("Walking");
    }
}




public class Q5_SOL {
}
