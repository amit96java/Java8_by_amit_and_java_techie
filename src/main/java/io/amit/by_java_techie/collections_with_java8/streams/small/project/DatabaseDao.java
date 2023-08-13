package io.amit.by_java_techie.collections_with_java8.streams.small.project;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDao {

    public static List<Employee> getEmployees(){
        List<Employee> lists = new ArrayList<>();
        lists.add(new Employee(176,"amit","it",600000));
        lists.add(new Employee(177,"rahul","hr",500000));
        lists.add(new Employee(178,"aman","client",800000));
        lists.add(new Employee(179,"rohini","ias",900000));
        return lists;

    }
}
