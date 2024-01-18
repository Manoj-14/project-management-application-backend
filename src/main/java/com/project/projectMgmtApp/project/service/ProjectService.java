package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ProjectEntity;

import java.util.List;

public interface ProjectService {
    public ProjectEntity addProject();

    public ProjectEntity updateProject(String id);

    public List<ProjectEntity> getProject();

    public ProjectEntity deleteProject();
}
