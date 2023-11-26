package pro.sky.java.course2.employeebook.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServise employeeServise;

    public DepartmentServiceImpl(EmployeeServise employeeServise) {
        this.employeeServise = employeeServise;
    }

    @Override

    public Employee getEmployeeOfDepartmentWithMaxSalary(Integer departmentId) {
        return employeeServise.printEmployee().values()
                .stream()
                .filter(employee -> departmentId.equals(employee.getDepartment()))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Отдел не найден!"));
    }

    @Override
    public Employee getEmployeeOfDepartmentWithMinSalary(Integer departmentId) {
        return employeeServise.printEmployee().values()
                .stream()
                .filter(employee -> departmentId.equals(employee.getDepartment()))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Отдел не найден!"));
    }

    @Override
    public List<Employee> getEmployeesOfDepartment(Integer departmentId) {
        return employeeServise.printEmployee().values()
                .stream()
                .filter(employee -> departmentId.equals(employee.getDepartment()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeServise.printEmployee().values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
