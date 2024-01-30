package com.project.projectMgmtApp.task.dto;

public class AssignmentDTO {
    private String id;
    private String employeeId;
    private String roleId;
    private String teamId;

    public AssignmentDTO() {
    }

    public AssignmentDTO(String employeeId, String roleId, String teamId) {
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.teamId = teamId;
    }

    public AssignmentDTO(String id, String employeeId, String roleId, String teamId) {
        this.id = id;
        this.employeeId = employeeId;
        this.roleId = roleId;
        this.teamId = teamId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "AssignmentDTO{" +
                "employeeId='" + employeeId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", taskId='" + teamId + '\'' +
                '}';
    }
}
