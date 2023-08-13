package io.amit.by_amit.abstract_class;

public abstract class Behavior {

    public void walk(String animalName, boolean isWalk) {
        System.out.println("is walking "+isWalk);
    }

    abstract void run(String animalName, boolean isRun);
}
