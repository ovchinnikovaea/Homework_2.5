package pro.sky.java.course2.employeebook.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.Service.EmployeeServise;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServise employeeServise;

    public EmployeeController(EmployeeServise employeeServise) {
        this.employeeServise = employeeServise;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstname,
                                @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeServise.addEmployee(employee);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstname,
                                 @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeServise.removeEmployee(employee);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstname,
                               @RequestParam("lastName") String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeServise.findEmployee(employee);
    }

    @GetMapping("/print")
    public List printEmployee() {
        return employeeServise.printEmployee();

    }
}

