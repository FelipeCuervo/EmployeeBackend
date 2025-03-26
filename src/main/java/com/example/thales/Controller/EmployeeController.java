package com.example.thales.Controller;

import com.example.thales.business.EmployeeBusiness;
import com.example.thales.model.Employee;
import com.example.thales.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeBusiness employeeBusiness;

    public EmployeeController(EmployeeService employeeService, EmployeeBusiness employeeBusiness) {
        this.employeeService = employeeService;
        this.employeeBusiness = employeeBusiness;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        List<Employee>employeeList = employeeService.getAllEmployees();
        employeeList.forEach(employeeBusiness::calculateAnnualSalary);
        return employeeList;
    }

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        return employeeBusiness.calculateAnnualSalary(employee);
    }

}
