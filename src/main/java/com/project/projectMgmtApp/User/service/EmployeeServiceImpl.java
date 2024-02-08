package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.exceptions.EmployeeNotFound;
import com.project.projectMgmtApp.User.exceptions.UserAccountNotFound;
import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.model.UserAccount;
import com.project.projectMgmtApp.User.repository.EmployeeRepository;
import com.project.projectMgmtApp.User.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,UserAccountRepository userAccountRepository) {
        this.employeeRepository = employeeRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId).stream().findFirst().orElse(null);
        if(employee != null){
            return employee;

        }
        else {
            throw new EmployeeNotFound("Employee not found");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee){
        Employee dbEmployee = employeeRepository.findById(employee.getId()).stream().findFirst().orElse(null);

        if(dbEmployee != null) {
            UserAccount user = userAccountRepository.findById(employee.getUserAccountId().getId()).stream().findFirst().orElse(null);
            if(user!=null) {
                return employeeRepository.save(employee);
            }
            else {
                throw new UserAccountNotFound("User Account not found");
            }
        }
        else throw new EmployeeNotFound("Employee not found");
    }

    @Override
    public void deleteEmployee(String employeeId){
        Employee employee = employeeRepository.findById(employeeId).stream().findFirst().orElse(null);
        if(employee != null) employeeRepository.deleteById(employeeId);
        else throw new EmployeeNotFound("Employee not found");
    }
}
