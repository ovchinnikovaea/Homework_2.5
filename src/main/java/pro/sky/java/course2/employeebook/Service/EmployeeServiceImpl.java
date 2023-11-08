package pro.sky.java.course2.employeebook.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeServise {

    private final Map<String, Employee> employees = new HashMap<>(Map.of());

    private static final int MAX_NUMBERS = 15;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.size() > MAX_NUMBERS) {
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников фирмы");
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Невозможно добавить, такой сотрудник уже существует");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Невозможно удалить, такой сотрудник не найден");
        }
        employees.remove(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Map<String, Employee> printEmployee() {
        return employees;
    }
}

