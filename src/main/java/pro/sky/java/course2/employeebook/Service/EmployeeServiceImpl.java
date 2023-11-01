package pro.sky.java.course2.employeebook.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServise {

    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Мария", "Крючкова"),
            new Employee("Николай", "Мельников"),
            new Employee("Михаил", "Голубев"),
            new Employee("Владимир", "Волков"),
            new Employee("Александра", "Миронова"),
            new Employee("Артём", "Давыдов"),
            new Employee("Даниил", "Климов"),
            new Employee("Виктор", "Белоусов"),
            new Employee("Мария", "Карпова"),
            new Employee("Сергей", "Котов")
    ));

    private static final int MAX_NUMBERS = 15;


    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.size() > MAX_NUMBERS) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников фирмы");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Невозможно добавить, такой сотрудник уже существует");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Невозможно удалить, такой сотрудник не найден");
        }
        employees.remove(employee);
        return employee;
    }


    @Override
    public Employee findEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public List<Employee> printEmployee() {
        return employees;
    }
}

