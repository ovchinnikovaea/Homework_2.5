package pro.sky.java.course2.employeebook.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.employeebook.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class DepartmentServiceImplTest {
    @ExtendWith(MockitoExtension.class)
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final List<Employee> employees = new ArrayList<>() {
        {
            add(new Employee("Ivanov", "Ivan", 2, 100_000));
            add(new Employee("Petrov", "Petr", 2, 150_000));
            add(new Employee("Andreev", "Ivan", 1, 90_000));
        }
    };

    @Test
    public void shouldReturnSumSalaryByDepartment() {

        int departmentId = 2;
        int expectedSum = 250_000;
        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee: employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.printEmployee()).thenReturn(employeeMap);

        Integer actualSum = departmentService.getSumSalaryByDepartment(departmentId);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnEmployeeOfDepartmentWithMaxSalalry() {

        int departmentId = 2;
        Employee expectedEmployee = employees.get(1);
        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee: employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.printEmployee()).thenReturn(employeeMap);

        Employee actualEmployee = departmentService.getEmployeeOfDepartmentWithMaxSalary(departmentId);

        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void shouldReturnEmployeeOfDepartmentWithMinSalalry() {

        int departmentId = 2;
        Employee expectedEmployee = employees.get(0);
        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee: employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.printEmployee()).thenReturn(employeeMap);

        Employee actualEmployee = departmentService.getEmployeeOfDepartmentWithMinSalary(departmentId);

        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void shouldReturnEmployeesOfDepartment() {

        int departmentId = 2;


        List<Employee> expectedEmployee = new ArrayList<>(){{
            add(employees.get(0));
            add(employees.get(1));
        }};

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee: employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.printEmployee()).thenReturn(employeeMap);

        List<Employee> actualEmployee = departmentService.getEmployeesOfDepartment(departmentId);

        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void shouldReturnAllEmployeesByDepartment() {

        Map<Integer, List<Employee>> expected = new HashMap<>() {{
            put(2, new ArrayList<>(){{
                add(employees.get(0));
                add(employees.get(1));
            }});
            put(1, new ArrayList<>(){{
                add(employees.get(2));
            }});
        }};

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee: employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.printEmployee()).thenReturn(employeeMap);

        Map<Integer, List<Employee>> actual = departmentService.getAllEmployees();

        Assertions.assertEquals(expected, actual);
    }
}
