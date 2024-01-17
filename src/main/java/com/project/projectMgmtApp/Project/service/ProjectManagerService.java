package com.project.projectMgmtApp.Project.service;

import com.project.projectMgmtApp.Project.entity.ProjectManagerEntity;

import java.util.List;

public interface ProjectManagerService {
    public ProjectManagerEntity addProjectManager();

    public ProjectManagerEntity updateProjectManager(String id);

    public List<ProjectManagerEntity> getProjectManager();

    public ProjectManagerEntity deleteProjectManager();
}
