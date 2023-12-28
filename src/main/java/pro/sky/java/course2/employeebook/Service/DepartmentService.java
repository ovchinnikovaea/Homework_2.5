package pro.sky.java.course2.employeebook.Service;

import pro.sky.java.course2.employeebook.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Integer getSumSalaryByDepartment (Integer departmentId);
    Employee getEmployeeOfDepartmentWithMaxSalary (Integer departmentId);

    Employee getEmployeeOfDepartmentWithMinSalary(Integer departmentId);

    List<Employee> getEmployeesOfDepartment(Integer departmentId);

   Map<Integer, List<Employee>> getAllEmployees();
}
