package com.tsekhanovich.functional.practice23;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Tsekhanovcih 11.11.2018
 * <p>
 * You have two classes: Employee (name: String, salary: Long) and Department
 * (name: String, code: String, employees: List<Employee>).
 * Both classes have getters for all fields with the corresponding names
 * (getName(), getSalary(), getEmployees() and so on).
 * <p>
 * Write a method using Stream API that calculates the general number of employees
 * with salary >= threshold for all departments whose code starts with string "111-" (without "").
 * Perhaps, flatMap method can help you to implement it.
 * <p>
 * Classes Employee and Department will be available during testing.
 * You can define your own classes for local testing.
 * <p>
 * Important. Use the given template for your method.
 * Pay attention to type of an argument and the returned value. Please, use only Stream API, no cycles.
 * <p>
 * Examples: there are 2 departments (in JSON notation) below and ﻿threshold = 20 000.
 * The result is 1 (because there is only one suitable employee).
 */

public class Task1 {

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold   is lower edge of salary
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream().
                filter(s -> s.getCode().startsWith("111-")).
                flatMap(s -> s.getEmployees()
                        .stream()
                        .filter(e -> e.getSalary() >= threshold))
                .count();
    }

    public static void main(String[] args) {
        List<Department> departments = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        departments.add(new Department("Test", "111-222", employees));

        calcNumberOfEmployees(departments, 8);
    }

}

class Department {

    private String name;
    private String code;
    private List<Employee> employees;

    public Department(String name, String code, List<Employee> employees) {
        this.name = name;
        this.code = code;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

class Employee {

    private String name;
    private Long salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
