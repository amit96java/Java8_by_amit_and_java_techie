package io.amit.by_amit.abstract_class_with_interface;

public class Animal extends Behavior implements LivingBehavior{
    @Override
    void run(String animalName, boolean isRun) {
        System.out.println(animalName+" is able to run "+isRun);
    }

    @Override
    public void run(String animalName) {

    }

    @Override
    public void infIsVagitarian(String animal, boolean isVegitarian) {

    }


//    public void walk(String animalName, boolean isWalk) {
//        System.out.println(animalName +" is able to walk "+isWalk);
//    }
}
