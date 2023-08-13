package io.amit.by_amit.abstract_class_with_interface;

public interface LivingBehavior {
//    void run(String animalName, boolean isRun);

    void run(String animalName);

    void infIsVagitarian(String animal, boolean isVegitarian);

    default void infLegs(String animal, int lengNo) {
        System.out.println(animal +" have "+lengNo+" legs");
    }


}
