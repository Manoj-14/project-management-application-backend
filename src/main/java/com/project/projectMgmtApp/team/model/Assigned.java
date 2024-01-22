package com.project.projectMgmtApp.team.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Assigned {
    @Id
    private String id;
    private int employeeId;
    private int roleId;
    private Task taskId;

    public Assigned() {
    }

    public Assigned(String id, int employee_id, int role_id, Task task_id) {
        this.id = id;
        this.employeeId = employee_id;
        this.roleId = role_id;
        this.taskId = task_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task getTeamId() {
        return taskId;
    }

    public void setTeamId(Task taskId) {
        this.taskId = taskId;
    }
}
