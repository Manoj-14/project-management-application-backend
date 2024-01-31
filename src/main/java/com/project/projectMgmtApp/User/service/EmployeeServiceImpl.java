package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.exceptions.EmployeeNotFound;
import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(String.valueOf(Integer.parseInt(employeeId)));
        return optionalEmployee.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) throws EmployeeNotFound {
        Employee dbEmployee = employeeRepository.findById(employee.getId()).stream().findFirst().orElse(null);
        if(dbEmployee != null) employeeRepository.save(employee);
        else throw new EmployeeNotFound("Employee not found");
        return null;
    }

    @Override
    public void deleteEmployee(String employeeId) throws EmployeeNotFound{
        Employee employee = employeeRepository.findById(employeeId).stream().findFirst().orElse(null);
        if(employee != null) employeeRepository.deleteById(employeeId);
        else throw new EmployeeNotFound("Employee not found");
    }
}
