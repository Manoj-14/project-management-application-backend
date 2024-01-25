package com.project.projectMgmtApp.project.service;

import com.project.projectMgmtApp.project.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    public ProjectEntity addProject(Map<String,String> projectEntity);

    public ProjectEntity updateProject(String id);

    public List<ProjectEntity> getProject();

    public ProjectEntity deleteProject();
}
