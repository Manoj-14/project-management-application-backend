package com.project.projectMgmtApp.Project.repository;

import com.project.projectMgmtApp.Project.entity.ProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<ProjectEntity,String> {
}
