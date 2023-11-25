package pro.sky.java.course2.employeebook.Service;

import pro.sky.java.course2.employeebook.Employee;

import java.util.Map;

public interface EmployeeServise {

    Employee addEmployee(String firstName, String lastname, Integer department, Integer salary);

    Employee removeEmployee(String firstName, String lastname);

    Employee findEmployee(String firstName, String lastname);

    Map<String, Employee> printEmployee();

}
