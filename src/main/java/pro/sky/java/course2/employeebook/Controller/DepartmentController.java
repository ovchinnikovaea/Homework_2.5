package pro.sky.java.course2.employeebook.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.Service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{id}/salary/sum")
    public Integer getSumSalaryByDepartment(@PathVariable Integer id) {
        return departmentService.getSumSalaryByDepartment(id);
    }
    @GetMapping("{id}/salary/max")
    public int getEmployeeOfDepartmentWithMaxSalary(@PathVariable Integer id) {
        return departmentService.getEmployeeOfDepartmentWithMaxSalary(id).getSalary();
    }

    @GetMapping("{id}/salary/min")
    public int getEmployeeOfDepartmentWithMinSalary(@PathVariable Integer id) {
        return departmentService.getEmployeeOfDepartmentWithMinSalary(id).getSalary();
    }

    @GetMapping("{id}/employees")
    public List<Employee> getEmployeesOfDepartment(@PathVariable Integer id) {
        return departmentService.getEmployeesOfDepartment(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}
