package io.amit.old.by_amit.abstract_class_with_interface;

public abstract class Behavior {

    public void walk(String animalName, boolean isWalk) {
        System.out.println("is walking "+isWalk);
    }

    abstract void run(String animalName, boolean isRun);
}
