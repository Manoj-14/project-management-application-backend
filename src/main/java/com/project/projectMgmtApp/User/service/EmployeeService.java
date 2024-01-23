package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.Employee;

import java.util.List;

public interface EmployeeService {
    public void createEmployee(Employee employee);

    public Employee getEmployeeById(String employeeId);

    List<Employee> getAllEmployees();

    public void updateEmployee(Employee employee);

    public void deleteEmployee(String employeeId);
}
