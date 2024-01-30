package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        try {
            employeeService.createEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee created Successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating employee");
        }
    }

    @GetMapping("/get-all-employees")
    public ResponseEntity<?> getEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<?> getEmployeeId(@Valid @PathVariable String id){
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("EmployeeId not found",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateUserAccount(@Valid @PathVariable String id){
        try{
            Employee existingEmployee = employeeService.getEmployeeById(id);
            if(existingEmployee == null){
                return new ResponseEntity<>("Employee Not Found with id :"+id, HttpStatus.NOT_FOUND);
            }
            employeeService.updateEmployee(existingEmployee);
            return new ResponseEntity<>("Employee Updated Successfully", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>("Employee deleted with id :"+id,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server error", HttpStatus.NOT_FOUND);
        }
    }

}
