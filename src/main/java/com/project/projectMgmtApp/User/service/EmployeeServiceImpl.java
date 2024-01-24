package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public void updateEmployee(Employee employee) {
        try{
            Optional<Employee> existingEmployeeOptional = employeeRepository.findById(employee.getId());

            if(existingEmployeeOptional.isPresent()){
                Employee existingEmployee = existingEmployeeOptional.get();
                existingEmployee.setEmployeeName(employee.getEmployeeName());
                existingEmployee.setEmployeeCode(employee.getEmployeeCode());
                existingEmployee.setUserAccountId(employee.getUserAccountId());

                employeeRepository.save(existingEmployee);
            }
            else {
                throw new IllegalArgumentException("Employee not found with ID: " + employee.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(String employeeId) {
        try{
            int id = Integer.parseInt(employeeId);
            Optional<Employee> existingEmployeeOptional = employeeRepository.findById(String.valueOf(id));

            if(existingEmployeeOptional.isPresent()){
                employeeRepository.deleteById(String.valueOf(id));
            }
            else {
                throw new IllegalArgumentException("Employee not found with ID: " + id);
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
