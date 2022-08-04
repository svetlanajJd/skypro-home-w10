package pro.sky.skyprohomew10;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeDepartmentServiceTest {
    private Employee employee = new Employee("Ivan", "Ivanov", 2, 83000);
    private Employee employee1 = new Employee("Fedor", "Fedorov", 2, 82000);
    private Employee employee2 = new Employee("Petr", "Petrov", 2, 81000);

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeDepartmentService out;

    @Test
    public void getAllDepartment() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        when(employeeService.printTotal()).thenReturn(expected);
        assertEquals(expected, employeeService.printTotal());
    }

    @Test
    public void minSalaryDepartment() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        expected.put(employee1.getFirstName() + " " + employee1.getLastName() + " " + employee1.getDepartment() + " " + employee1.getSalary(), employee1);
        expected.put(employee2.getFirstName() + " " + employee2.getLastName() + " " + employee2.getDepartment() + " " + employee2.getSalary(), employee2);

        when(employeeService.printTotal()).thenReturn(expected);
        assertEquals(employee2, out.minSalary(2));
    }

    @Test
    public void maxSalaryDepartment() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        expected.put(employee1.getFirstName() + " " + employee1.getLastName() + " " + employee1.getDepartment() + " " + employee1.getSalary(), employee1);
        expected.put(employee2.getFirstName() + " " + employee2.getLastName() + " " + employee2.getDepartment() + " " + employee2.getSalary(), employee2);

        when(employeeService.printTotal()).thenReturn(expected);
        assertEquals(employee, out.maxSalary(2));
    }

    @Test
    public void SalaryDepartmentThrow() {
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        expected.put(employee1.getFirstName() + " " + employee1.getLastName() + " " + employee1.getDepartment() + " " + employee1.getSalary(), employee1);
        expected.put(employee2.getFirstName() + " " + employee2.getLastName() + " " + employee2.getDepartment() + " " + employee2.getSalary(), employee2);
        when(employeeService.printTotal()).thenReturn(expected);
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalary(5));
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalary(5));
    }
}
