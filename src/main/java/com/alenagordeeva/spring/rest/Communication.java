package com.alenagordeeva.spring.rest;

import com.alenagordeeva.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/spring_course_rest/api/employees";

    @Autowired
    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        //с помощью кода ниже отправляю request, и его результат получаю в responseEntity
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null
                , new ParameterizedTypeReference<List<Employee>>() {});
        // получаю из responseEntity полезную нагрузку - список всех работников
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee (int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);

        return employee;
    }

    //метод и сохраняет нового, и обновляет существующего работника, в зависимости от его id
    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if(id==0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID " + id + " was updated");
        }


    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted from DB");
    }
}
