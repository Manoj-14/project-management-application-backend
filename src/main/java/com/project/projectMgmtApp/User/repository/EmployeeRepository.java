package com.project.projectMgmtApp.User.repository;

import com.project.projectMgmtApp.User.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
