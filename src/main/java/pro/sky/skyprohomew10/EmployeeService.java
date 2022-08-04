package pro.sky.skyprohomew10;
import org.apache.catalina.util.ParameterMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class EmployeeService {
    private final Map<String, Employee> contacts = new HashMap<>();


    public Employee addEmployee(String firstName, String lastName, int department, float salary) {
        if (!firstName.isBlank() && !lastName.isBlank() && StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), department, salary);
                      String key = getKey(firstName, lastName, department, salary);
            if (contacts.containsKey(getKey(employee.getFirstName(),employee.getLastName(),employee.getDepartment(),employee.getSalary()))) {
                throw new EmployeeAlreadyAddedException();
            }
            contacts.put(key, employee);
            return employee;
        }
        throw new EmployeeException();
    }

    public Employee findEmployee(String firstName, String lastName, int department, float salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (contacts.containsKey(getKey(employee.getFirstName(),employee.getLastName(),employee.getDepartment(),employee.getSalary()))) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee removeEmployee(String firstName, String lastName, int department, float salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (contacts.containsKey(getKey(employee.getFirstName(),employee.getLastName(),employee.getDepartment(),employee.getSalary()))) {
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
