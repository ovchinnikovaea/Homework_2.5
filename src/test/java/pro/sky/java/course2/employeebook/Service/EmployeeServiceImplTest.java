package pro.sky.java.course2.employeebook.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeebook.exception.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceImplTest {

    private Employee employee;

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @BeforeEach
    public void setUp() {
        employee = new Employee("Ivanov", "Ivan", 2, 100_000);
    }

    @Test
    public void shouldAddAndReturnEmployee() {
        Employee expectedEmployee = employee;

        Employee actualEmployee = out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());

        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test

    public void shouldThrowEmployeeStorageIsFullExceptionWhenEmployeeBookIsFull() {

        Employee employee1 = new Employee("Petrov", "Petr", 3, 70_000);
        Employee employee2 = new Employee("Andreev", "Petr", 2, 80_000);
        Employee employee3 = new Employee("Smirnov", "Petr", 1, 90_000);
        Employee expectedEmployee = new Employee("Ovchinnikova", "Elena", 2, 100_000);

        out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());
        out.addEmployee(employee1.getFirstName(), employee1.getLastName(), employee1.getDepartment(), employee1.getSalary());
        out.addEmployee(employee2.getFirstName(), employee2.getLastName(), employee2.getDepartment(), employee2.getSalary());
        out.addEmployee(employee3.getFirstName(), employee3.getLastName(), employee3.getDepartment(), employee3.getSalary());

        assertThrows(EmployeeStorageIsFullException.class, () ->
                out.addEmployee(expectedEmployee.getFirstName(), expectedEmployee.getLastName(), expectedEmployee.getDepartment(), expectedEmployee.getSalary()));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenEmployeeAlreadyBeenAdded() {
        out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());

        assertThrows(EmployeeAlreadyAddedException.class, () ->
                out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary()));
    }

    @Test
    public void shouldCorrectlyRemoveEmployee() {

        out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());

        Employee actual = out.removeEmployee(employee.getFirstName(), employee.getLastName());

        Assertions.assertEquals(employee, actual);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionIfEmployeeNotFound() {
       assertThrows(EmployeeNotFoundException.class, () ->
                out.removeEmployee(employee.getFirstName(), employee.getLastName()));
    }

    @Test
    public void shouldCorrectlyFindEmployee() {
        out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());

        Employee actual = out.findEmployee(employee.getFirstName(), employee.getLastName());

        Assertions.assertEquals(employee, actual);
    }

    @Test
    public void ThrowEmployeeNotFoundExceptionIfEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () ->
                out.findEmployee(employee.getFirstName(), employee.getLastName()));
    }


}
