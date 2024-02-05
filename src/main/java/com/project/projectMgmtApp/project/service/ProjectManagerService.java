package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ProjectManagerEntity;

import java.util.List;
import java.util.Map;

public interface ProjectManagerService {
    public ProjectManagerEntity addProjectManager(Map<String,String> projectManager);

    public ProjectManagerEntity updateProjectManager(Map<String,String> projectManager);

    public List<ProjectManagerEntity> getProjectManager();

    public ProjectManagerEntity getProjectManagerById(String id);

    public ProjectManagerEntity getProjectManagerByProjectId(String id);

    public ProjectManagerEntity getProjectManagerByUserAccountId(String id);

    public void deleteProjectManager(String id);

}
