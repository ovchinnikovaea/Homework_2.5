package pro.sky.java.course2.employeebook.Service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.EmployeeStorageIsFullException;
import pro.sky.java.course2.employeebook.exception.InvalidateInputException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeServise {

    private final Map<String, Employee> employees = new HashMap<>();

    private final int MAX_NUMBERS = 15;

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer department, Integer salary) {

        validateInput(firstName, lastName);

        if (employees.size() > MAX_NUMBERS) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников фирмы");
        }
        if (employees.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException("Невозможно добавить, такой сотрудник уже существует");
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
        employees.put(employee.getFullName(), employee);
        return employee;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        validateInput(firstName, lastName);

        if (!employees.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Невозможно удалить, такой сотрудник не найден");
        }
        return employees.remove(getKey(firstName, lastName));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        validateInput(firstName, lastName);

        Employee employee = employees.get(getKey(firstName, lastName));
        if (!employees.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Map<String, Employee> printEmployee() {
        return Collections.unmodifiableMap(employees);
    }

    private static String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    private static String getKey(Employee employee) {
        return employee.getFullName();
    }

    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidateInputException();
        }
    }
}


