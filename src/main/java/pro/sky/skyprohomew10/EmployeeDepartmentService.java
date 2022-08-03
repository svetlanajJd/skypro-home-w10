package pro.sky.skyprohomew10;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.max;
import static java.util.stream.Collectors.groupingBy;

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

    public Map<Integer, Employee> allEmployeeDepartmentMap() {
        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
        return listContactsDepartment.stream()
                .collect(Collectors.toMap(e -> e.getDepartment(), e -> e));
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

//        List<Employee> listContactsDepartment = new ArrayList<>(employeeService.printTotal().values());
//         Optional<Employee>streamContactsDepartment = listContactsDepartment.stream()
//                .sorted(Comparator.comparing(Employee::getDepartment))
//                .filter(d -> d.getDepartment() == department)
//                .min(Comparator.comparingInt(employee -> (int) employee.getSalary()));
//        int salaryMin= Integer.parseInt(String.valueOf(streamContactsDepartment));
//               return salaryMin;
    }
}
