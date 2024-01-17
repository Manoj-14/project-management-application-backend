package com.project.projectMgmtApp.Project.service;

import com.project.projectMgmtApp.Project.entity.ProjectEntity;

import java.util.List;

public interface ProjectService {
    public ProjectEntity addProject();

    public ProjectEntity updateProject(String id);

    public List<ProjectEntity> getProject();

    public ProjectEntity deleteProject();
}
