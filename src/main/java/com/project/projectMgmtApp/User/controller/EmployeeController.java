package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        try {
            employeeService.createEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee created Successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating employee");
        }
    }

}
