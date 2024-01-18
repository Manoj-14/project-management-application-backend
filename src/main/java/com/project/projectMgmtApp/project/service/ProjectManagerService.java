package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ProjectManagerEntity;

import java.util.List;

public interface ProjectManagerService {
    public ProjectManagerEntity addProjectManager();

    public ProjectManagerEntity updateProjectManager(String id);

    public List<ProjectManagerEntity> getProjectManager();

    public ProjectManagerEntity deleteProjectManager();
}
