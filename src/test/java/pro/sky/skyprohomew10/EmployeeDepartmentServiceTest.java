package pro.sky.skyprohomew10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeDepartmentServiceTest {
    private Employee employee = new Employee("Ivan", "Ivanov", 2, 54211);

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeDepartmentService out;

    @Test
    public void getAllDepartment() {
        assertNotNull(employeeService);
        Map<String, Employee> actual = new HashMap<>();
        actual.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        when(employeeService.printTotal()).thenReturn(actual);
        assertEquals(actual, employeeService.printTotal());
    }

    @Test
    public void minSalaryDepartment() {
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());
        when(out.minSalary(2)).thenReturn((int) employee.getSalary());
        assertEquals((int) employee.getSalary(), out.minSalary(2));
    }

    @Test
    public void maxSalaryDepartment() {
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());
        when(out.maxSalary(2)).thenReturn((int) employee.getSalary());
        assertEquals((int) employee.getSalary(), out.maxSalary(2));
    }
}
