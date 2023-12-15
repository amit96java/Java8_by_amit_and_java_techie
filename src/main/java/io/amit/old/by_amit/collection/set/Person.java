package io.amit.old.by_amit.collection.set;

import java.util.HashSet;
import java.util.Objects;

public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Note: run below main method with and without equals and hashCode method.
     * youtube: https://www.youtube.com/watch?v=zgxf0eYqRSg
     *
     * https://www.geeksforgeeks.org/load-factor-in-hashmap-in-java-with-examples/
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        HashSet<Person> people = new HashSet<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Alice", 30));

        System.out.println("size of set is " + people.size());
    }
}
