package com.project.projectMgmtApp.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projectManager")
public class ProjectManagerEntity {
    @Id
    private String id;
    private ProjectEntity project_id;
    private int user_account_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjectEntity getProject_id() {
        return project_id;
    }

    public void setProject_id(ProjectEntity project_id) {
        this.project_id = project_id;
    }

    public int getUser_account_id() {
        return user_account_id;
    }

    public void setUser_account_id(int user_account_id) {
        this.user_account_id = user_account_id;
    }

    public ProjectManagerEntity(String id, ProjectEntity project_id, int user_account_id) {
        this.id = id;
        this.project_id = project_id;
        this.user_account_id = user_account_id;
    }

    public ProjectManagerEntity() {
    }

    @Override
    public String toString() {
        return "ProjectManagerEntity{" +
                "id=" + id +
                ", project_id=" + project_id +
                ", user_account_id=" + user_account_id +
                '}';
    }
}
