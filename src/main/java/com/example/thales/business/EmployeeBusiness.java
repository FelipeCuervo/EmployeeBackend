package com.example.thales.business;

import com.example.thales.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBusiness {

    public Employee calculateAnnualSalary(Employee employee){
        if(employee != null){
            employee.setEmployee_annual_salary(employee.getEmployee_salary() * 12);
        }
        return employee;
    }
}
