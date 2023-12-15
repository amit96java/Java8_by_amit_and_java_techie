package io.amit.old.by_amit.comparator_class;


public class Customer {
    public int id;
    public String name;
    public int salary;

    public Customer(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
