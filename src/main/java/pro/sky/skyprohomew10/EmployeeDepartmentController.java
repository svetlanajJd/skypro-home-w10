package pro.sky.skyprohomew10;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeDepartmentController {
    private EmployeeDepartmentService employeeDepartmentService;

    public EmployeeDepartmentController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @GetMapping("/all")
    public Map<Integer, Employee> all() {
        return employeeDepartmentService.allEmployeeDepartmentMap();
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("departmentID") int department) {
        return employeeDepartmentService.maxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("departmentID") int department) {
        return employeeDepartmentService.minSalary(department);
    }
}
