package com.project.projectMgmtApp.project.entity;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="project")
public class ProjectEntity {
    @Id
    private String id;
    @NotNull(message = "is required")
    private String project_name;
    @NotNull(message = "is required")
    private Date planned_start_date;
    @NotNull(message = "is required")
    private Date planned_end_date;
    @NotNull(message = "is required")
    private Date actual_start_date;
    @NotNull(message = "is required")
    private Date actual_end_date;
    @NotNull(message = "is required")
    private String project_description;
    @NotNull(message = "is required")
    @DBRef
    private ClientEntity client_id;

    public ProjectEntity(String id, String project_name, Date planned_start_date, Date planned_end_date, Date actual_start_date, Date actual_end_date, String project_description, ClientEntity client_id) {
        this.id = id;
        this.project_name = project_name;
        this.planned_start_date = planned_start_date;
        this.planned_end_date = planned_end_date;
        this.actual_start_date = actual_start_date;
        this.actual_end_date = actual_end_date;
        this.project_description = project_description;
        this.client_id = client_id;
    }

    public ProjectEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Date getPlanned_start_date() {
        return planned_start_date;
    }

    public void setPlanned_start_date(Date planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    public Date getPlanned_end_date() {
        return planned_end_date;
    }

    public void setPlanned_end_date(Date planned_end_date) {
        this.planned_end_date = planned_end_date;
    }

    public Date getActual_start_date() {
        return actual_start_date;
    }

    public void setActual_start_date(Date actual_start_date) {
        this.actual_start_date = actual_start_date;
    }

    public Date getActual_end_date() {
        return actual_end_date;
    }

    public void setActual_end_date(Date actual_end_date) {
        this.actual_end_date = actual_end_date;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public ClientEntity getClient_id() {
        return client_id;
    }

    public void setClient_id(ClientEntity client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "ProjectEntity{" +
                "id=" + id +
                ", project_name='" + project_name + '\'' +
                ", planned_start_date=" + planned_start_date +
                ", planned_end_date=" + planned_end_date +
                ", actual_start_date=" + actual_start_date +
                ", actual_end_date=" + actual_end_date +
                ", project_description='" + project_description + '\'' +
                ", client_id=" + client_id +
                '}';
    }
}
