package com.project.projectMgmtApp.task.model;

import com.project.projectMgmtApp.User.model.Employee;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Assigned {
    @Id
    private String id;
    private Employee employee;
    private String roleId;
//    @NotNull(message = "Please enter task id")
    @DBRef
    private Task task;

    public Assigned() {
    }

    public Assigned(String id, Employee employee_id, String role_id, Task task_id) {
        this.id = id;
        this.employee = employee_id;
        this.roleId = role_id;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
