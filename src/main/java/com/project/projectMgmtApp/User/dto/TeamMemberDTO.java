package com.project.projectMgmtApp.User.dto;


public class TeamMemberDTO {

    private String id;

    private String teamId;

    public TeamMemberDTO() {
    }

    private String employeeId;

    private String roleId;

    public TeamMemberDTO(String id, String teamId, String employeeId, String roleId) {
        this.id = id;
        this.teamId = teamId;
        this.employeeId = employeeId;
        this.roleId = roleId;
    }

    public TeamMemberDTO(String teamId, String employeeId, String roleId) {
        this.teamId = teamId;
        this.employeeId = employeeId;
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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

    @Override
    public String toString() {
        return "TeamMemberDTO{" +
                "id='" + id + '\'' +
                ", teamId='" + teamId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
