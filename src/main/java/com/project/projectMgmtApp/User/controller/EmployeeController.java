package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.exceptions.EmployeeNotFound;
import com.project.projectMgmtApp.User.exceptions.UserAccountNotFound;
import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.model.UserAccount;
import com.project.projectMgmtApp.User.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee){

            employeeService.createEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeId(@Valid @PathVariable String id){
        Employee employee = employeeService.getEmployeeById(id);

            return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserAccount(@Valid @RequestBody Employee employee, @PathVariable String id){
        if(id==null){
            throw new NullPointerException("Employee id is null.");
        } else {
            employee.setId(id);
        }
            Employee savedEmployee = employeeService.updateEmployee(employee);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
            return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){

            employeeService.deleteEmployee(id);
            return ResponseEntity.accepted().build();

    }

}
