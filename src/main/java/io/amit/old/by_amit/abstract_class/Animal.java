package io.amit.old.by_amit.abstract_class;

public class Animal extends Behavior{
    @Override
    void run(String animalName, boolean isRun) {
        System.out.println("from class Animal");
    }

    public void walk(String animalName, boolean isWalk) {
        System.out.println("from class Animal");
    }
}
