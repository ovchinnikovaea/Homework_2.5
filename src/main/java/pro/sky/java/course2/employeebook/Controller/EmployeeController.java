package pro.sky.java.course2.employeebook.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeebook.Employee;
import pro.sky.java.course2.employeebook.Service.EmployeeServise;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServise employeeServise;

    public EmployeeController(EmployeeServise employeeServise) {

        this.employeeServise = employeeServise;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstname,
                                @RequestParam("lastName") String lastname,
                                @RequestParam("department") Integer department,
                                @RequestParam("salary") Integer salary) {
        return employeeServise.addEmployee(firstname, lastname, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstname,
                                   @RequestParam("lastName") String lastname) {
        return employeeServise.removeEmployee(firstname, lastname);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstname,
                                 @RequestParam("lastName") String lastname) {
        return employeeServise.findEmployee(firstname, lastname);
    }

    @GetMapping("/print")
    public Map<String, Employee> printEmployee() {
        return employeeServise.printEmployee();

    }

}

