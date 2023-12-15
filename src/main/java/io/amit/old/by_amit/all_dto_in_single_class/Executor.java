package io.amit.old.by_amit.all_dto_in_single_class;
import static io.amit.old.by_amit.all_dto_in_single_class.Modules.*;


public class Executor {

    public static void main(String[] args) {
        Employee employee = EMPLOYEE();
        employee.empId = "1";
        employee.name = "amit";
        Customer customer = CUSTOMER();
        customer.name = "shiva";
        customer.custId = "1";
        Customer customer2 = CUSTOMER();
        customer2.name = "Rudra";
        customer2.custId = "2";
        System.out.println(employee);
        System.out.println("object reference "+employee.hashCode());
        System.out.println(customer);
        System.out.println("object reference "+customer.hashCode());
        System.out.println(customer2);
        System.out.println("object reference "+customer2.hashCode());
    }
}
