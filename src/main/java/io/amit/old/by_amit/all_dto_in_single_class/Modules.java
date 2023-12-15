package io.amit.old.by_amit.all_dto_in_single_class;

public class Modules {

    public static Employee EMPLOYEE() {
        return new Employee();
    }

    public static Customer CUSTOMER() {
        return new Customer();
    }
}

class Employee {
    public String name;
    public String empId;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}

class Customer {
    public String name;
    public String custId;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", custId='" + custId + '\'' +
                '}';
    }
}
