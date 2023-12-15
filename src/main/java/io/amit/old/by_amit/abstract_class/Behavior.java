package io.amit.old.by_amit.abstract_class;

public abstract class Behavior {

    public void walk(String animalName, boolean isWalk) {
        System.out.println("from class Behavior");
    }

    abstract void run(String animalName, boolean isRun);
}
