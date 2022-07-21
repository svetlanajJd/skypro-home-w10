package pro.sky.skyprohomew10;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.net.BindException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<String, Employee> contacts = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName, int department, float salary) {
        if (!firstName.isBlank() && !lastName.isBlank()) {
            Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), department, salary);
            String key = getKey(firstName, lastName, department, salary);
            if (contacts.containsKey(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            contacts.put(key, employee);
            return employee;
        }
        throw new EmployeeException();
    }

    public Employee findEmployee(String firstName, String lastName, int department, float salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (contacts.containsKey(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee removeEmployee(String firstName, String lastName, int department, float salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (contacts.containsKey(employee)) {
            contacts.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Map<String, Employee> printTotal() {
        return new HashMap<>(contacts);
    }

    private String getKey(String firstName,
                          String lastName,
                          int department,
                          float salary) {
        return firstName + " " + lastName + " " + department + " " + salary;
    }

}
