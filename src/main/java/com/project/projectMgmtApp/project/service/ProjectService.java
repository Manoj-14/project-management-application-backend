package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    public ProjectEntity addProject(Map<String,String> projectEntity);

    public ProjectEntity updateProject(Map<String,String> projectEntity);

    public List<ProjectEntity> getProject();

    public ProjectEntity getProjectById(String id);

    public void deleteProject(String id);

    public List<ProjectEntity> getProjectByClientId(String  id);
}
