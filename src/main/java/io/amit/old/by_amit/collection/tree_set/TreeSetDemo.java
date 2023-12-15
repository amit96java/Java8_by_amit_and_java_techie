package io.amit.old.by_amit.collection.tree_set;

import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
//        List<String> fruitlist = new ArrayList<>();
//        fruitlist.add("mango");
//        fruitlist.add("applice");
//        fruitlist.add("donkey");
//        fruitlist.add("papaya");
//        fruitlist.add("ananas");
        TreeSet<String> tree_set
                = new TreeSet<String>();
        System.out.println("tree set is "+tree_set);

        tree_set.add("mango");
        tree_set.add("applice");
        tree_set.add("dondky");
        tree_set.add("papaya");
        tree_set.add("ananas");

        System.out.println("new "+tree_set);


    }
}
