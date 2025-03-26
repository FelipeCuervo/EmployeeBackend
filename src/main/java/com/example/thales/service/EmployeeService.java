package com.example.thales.service;

import com.example.thales.model.Employee;
import com.example.thales.model.EmployeeResponse;
import com.example.thales.model.EmployeeResponseById;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://dummy.restapiexample.com/api/v1";

    public List<Employee>getAllEmployees(){
        ResponseEntity<EmployeeResponse> response = restTemplate.getForEntity(BASE_URL+"/employees", EmployeeResponse.class);
        return response.getBody().getData();
    }

    public Employee getEmployeeById(int id){
        ResponseEntity<EmployeeResponseById>response =restTemplate.getForEntity(BASE_URL+"/employee/"+id, EmployeeResponseById.class);
        return response.getBody().getData();
    }

}
