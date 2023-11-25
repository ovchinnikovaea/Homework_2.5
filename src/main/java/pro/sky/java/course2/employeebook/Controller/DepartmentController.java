package pro.sky.java.course2.employeebook.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.Service.DepartmentService;
import pro.sky.java.course2.employeebook.Service.EmployeeServise;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeOfDepartmentWithMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeOfDepartmentWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeOfDepartmentWithMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeeOfDepartmentWithMinSalary(departmentId);
    }

    @GetMapping(value = "all", params = "departmentId")
    public List<Employee> getEmployeesOfDepartment(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.getEmployeesOfDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}
