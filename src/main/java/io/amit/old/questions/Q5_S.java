package io.amit.old.questions;


/**
 * A class should have only one reason to change, meaning it
 * should have only one job or responsibility.
 */


// A class handling employee details
class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Only methods related to Employee details
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}

// A separate class handling employee persistence
class EmployeeRepository {
    public void save(Employee employee) {
        // Logic to save employee to a database
    }
}


public class Q5 {
}
