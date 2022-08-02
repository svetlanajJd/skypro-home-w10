package pro.sky.skyprohomew10;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.max;

@Service
public class EmployeeDepartmentService {
    private final EmployeeService employeeService;

    public EmployeeDepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> all() {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        listContactsDepartment.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return listContactsDepartment;
    }

    public int maxSalary(int department) {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        Optional<Employee> streamContactsDepartment = listContactsDepartment.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .filter(d -> d.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> (int) employee.getSalary()));
        int salaryMax= Integer.parseInt(String.valueOf(streamContactsDepartment));
        return salaryMax;
    }

    public int minSalary(int department) {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
         Optional<Employee>streamContactsDepartment = listContactsDepartment.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .filter(d -> d.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> (int) employee.getSalary()));
        int salaryMin= Integer.parseInt(String.valueOf(streamContactsDepartment));
               return salaryMin;
    }
}
