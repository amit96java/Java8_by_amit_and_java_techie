package io.amit.by_amit.abstract_class;

public class Animal extends Behavior{
    @Override
    void run(String animalName, boolean isRun) {
        System.out.println(animalName+" is able to run "+isRun);
    }

//    public void walk(String animalName, boolean isWalk) {
//        System.out.println(animalName +" is able to walk "+isWalk);
//    }
}
