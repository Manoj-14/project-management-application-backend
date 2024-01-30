package com.project.projectMgmtApp.task.model;

import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.model.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Assignment {
    @Id
    private String id;
    @DBRef
    private Employee employee;
    @DBRef
    private Role role;
    @DBRef
    private Task task;

    public Assignment() {
    }

    public Assignment(String id, Employee employee_id, Role role_id, Task task_id) {
        this.id = id;
        this.employee = employee_id;
        this.role = role_id;
        this.task = task_id;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
