package pro.sky.skyprohomew10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
        Map<String, Employee> expected = new HashMap<>();
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        when(employeeService.printTotal()).thenReturn(expected);
        assertEquals(expected, employeeService.printTotal());
    }

    @Test
    public void minSalaryDepartment() {
        Map<String, Employee> expected = new HashMap<>();
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        when(employeeService.printTotal()).thenReturn(expected);
        assertEquals(employee, out.minSalary(2));
    }

    @Test
    public void maxSalaryDepartment() {
        Map<String, Employee> expected = new HashMap<>();
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        when(employeeService.printTotal()).thenReturn(expected);
        assertEquals(employee, out.maxSalary(2));
    }

    @Test
    public void SalaryDepartmentThrow() {
        Map<String, Employee> expected = new HashMap<>();
        employeeService.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());
        expected.put(employee.getFirstName() + " " + employee.getLastName() + " " + employee.getDepartment() + " " + employee.getSalary(), employee);
        when(out.minSalary(anyInt())).thenThrow(EmployeeNotFoundException.class);
        assertThrows(EmployeeNotFoundException.class,()-> out.maxSalary(anyInt()));
        when(out.minSalary(anyInt())).thenThrow(EmployeeNotFoundException.class);
        assertThrows(EmployeeNotFoundException.class,()-> out.minSalary(anyInt()));
    }
}
