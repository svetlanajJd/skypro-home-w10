package pro.sky.skyprohomew10;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentService {
    private final EmployeeService employeeService;

    public EmployeeDepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> allEmployeeDepartment(Integer department) {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        return listContactsDepartment.stream()
                .filter(e -> e.getDepartment() == department).collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> allEmployeeDepartmentMap() {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        return listContactsDepartment.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()));
    }

    public Employee maxSalary(int department) {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        return listContactsDepartment.stream()
                .filter(d -> d.getDepartment() == department)
                .max(Comparator.comparing(employee -> employee.getSalary())).orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee minSalary(int department) {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        return listContactsDepartment.stream()
                .filter(d -> d.getDepartment() == department)
                .min(Comparator.comparing(employee -> employee.getSalary())).orElseThrow(EmployeeNotFoundException::new);
    }
}
