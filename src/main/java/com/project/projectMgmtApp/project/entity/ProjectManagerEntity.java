package com.project.projectMgmtApp.project.entity;

import com.project.projectMgmtApp.User.model.UserAccount;
import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projectManager")
public class ProjectManagerEntity {
    @Id
    private String id;
    @DBRef
    private ProjectEntity projectId;
    @DBRef
    private UserAccount userAccountId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjectEntity getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectEntity projectId) {
        this.projectId = projectId;
    }

    public UserAccount getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(UserAccount userAccountId) {
        this.userAccountId = userAccountId;
    }

    public ProjectManagerEntity( ProjectEntity projectId, UserAccount userAccountId) {

        this.projectId = projectId;
        this.userAccountId = userAccountId;
    }

    public ProjectManagerEntity() {
    }

    @Override
    public String toString() {
        return "ProjectManagerEntity{" +
                "id=" + id +
                ", project_id=" + projectId +
                ", user_account_id=" + userAccountId +
                '}';
    }
}
