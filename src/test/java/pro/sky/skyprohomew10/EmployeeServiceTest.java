package pro.sky.skyprohomew10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {
    private EmployeeService out = new EmployeeService();
    private Employee employee;

    @BeforeEach
    public void setAp() {
        employee = new Employee("Ivan", "Ivanov", 2, 54211);
        out.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());
    }

    @Test
    public void getAddEmployee() {
        Employee actual = out.addEmployee("Petr", "Petrov", 2, 54211);
        Employee expected = new Employee("Petr", "Petrov", 2, 54211);
        assertEquals(actual, expected);
    }

    @Test
    public void getAddEmployeeException() {
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> out.addEmployee("Ivan", "Ivanov", 2, 54211));
    }

    @Test
    public void getAllEmployee() {
        Map<String, Employee> actual = out.printTotal();
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        assertEquals(actual,expected);
    }

    @Test
    public void getFindEmployee() {
        Employee actual = out.findEmployee("Ivan", "Ivanov", 2, 54211);
        Employee expected = employee;
        assertEquals(actual, expected);
    }

    @Test
    public void getFindEmployeeException() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee("Petr", "Petrov", 2, 54211));
    }

    @Test
    public void getRemoveEmployee() {
        Employee actual = out.removeEmployee("Ivan", "Ivanov", 2, 54211);
        Employee expected = employee;
        assertEquals(actual, expected) ;
    }

    @Test
    public void getRemoveEmployeeException() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee("Petr", "Petrov", 2, 54211));
    }
}
