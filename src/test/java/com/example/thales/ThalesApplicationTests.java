package com.example.thales;

import com.example.thales.business.EmployeeBusiness;
import com.example.thales.model.Employee;
import com.example.thales.model.EmployeeResponse;
import com.example.thales.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThalesApplicationTests {

    private final EmployeeBusiness employeeBusiness = new EmployeeBusiness();
    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void testCalculateAnnualSalary() {
        Employee employee = new Employee();
        employee.setEmployee_salary(5000);

        Employee result = employeeBusiness.calculateAnnualSalary(employee);

        assertNotNull(result);
        assertEquals(60000, result.getEmployee_annual_salary());
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        assertNotNull(employees);
    }


}
