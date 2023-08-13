package io.amit.by_java_techie.collections_with_java8.streams.small.project;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {
    public static List<Employee> evaluateUsers(String input){
        return (input.equalsIgnoreCase("tax"))
                ?
                DatabaseDao.getEmployees().stream().filter(employee -> employee.getSalary()>500000).collect(Collectors.toList())
                :
                DatabaseDao.getEmployees().stream().filter(employee -> employee.getSalary()<=500000).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(evaluateUsers("nontax"));
    }
}
