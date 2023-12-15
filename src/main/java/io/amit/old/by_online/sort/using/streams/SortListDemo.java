package io.amit.old.by_online.sort.using.streams;

import io.amit.old.by_online.streams.small.project.DatabaseDao;
import io.amit.old.by_online.streams.small.project.Employee;

import java.util.*;

public class SortListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(5);
        list.add(9);
        list.add(15);
        Collections.sort(list);//ascending
        Collections.reverse(list);
        System.out.println(list);
        /**
         * conventional ascending
         */
        list.stream().sorted().forEach(num -> System.out.println(num));
        /**
         * conventional descending
         */
        list.stream().sorted(Comparator.reverseOrder()).forEach(num -> System.out.println(num));

        List<Employee> employees = DatabaseDao.getEmployees();
        /**
         * sorting using lambda.
         */
        Collections.sort(employees, ((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())));//ascending order

        System.out.println(employees);

        /**
         * using stream
         */
        employees.stream().sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())).forEach(System.out::println);

        /**
         * using stream more advance
         */
        employees.stream().sorted(Comparator.comparing(employee -> employee.getSalary())).forEach(System.out::println);

        /**
         * using method reference with getter call , more more advance
         */
        System.out.println("based on name");
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
    }
}
