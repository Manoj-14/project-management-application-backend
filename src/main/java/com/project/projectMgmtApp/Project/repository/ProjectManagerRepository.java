package com.project.projectMgmtApp.Project.repository;

import com.project.projectMgmtApp.Project.entity.ProjectManagerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectManagerRepository extends MongoRepository<ProjectManagerEntity,String> {
}
