package pro.sky.java.course2.employeebook.Service;

import pro.sky.java.course2.employeebook.Employee;

import java.util.Map;

public interface EmployeeServise {

    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    Map<String, Employee> printEmployee();
}
