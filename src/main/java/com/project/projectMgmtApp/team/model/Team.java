package com.project.projectMgmtApp.team.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document
public class Team {
    @JsonIgnore
    @Id
    private int id;
    @NotNull(message = "Task name can't be empty")
    private String task_name;

    private int project_id;
    private int priority;
    @NotNull(message = "Description can't be empty")
    private String description;
    @NotNull(message = "Planned start date can't be empty")
    private Date planned_start_date;
    @NotNull(message = "Planned end date can't be empty")
    private Date planned_end_date;
    @NotNull(message = "Actual start time can't be empty")
    private LocalDateTime actual_start_time;
    @NotNull(message = "Actual end time can't be empty")
    private LocalDateTime actual_end_time;

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDateTime getActual_start_time() {
        return actual_start_time;
    }

    public void setActual_start_time(LocalDateTime actual_start_time) {
        this.actual_start_time = actual_start_time;
    }

    public LocalDateTime getActual_end_time() {
        return actual_end_time;
    }

    public void setActual_end_time(LocalDateTime actual_end_time) {
        this.actual_end_time = actual_end_time;
    }
}
