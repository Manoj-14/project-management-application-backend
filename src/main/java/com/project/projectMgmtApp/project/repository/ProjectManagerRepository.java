package com.project.projectMgmtApp.project.repository;

import com.project.projectMgmtApp.project.entity.ProjectManagerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectManagerRepository extends MongoRepository<ProjectManagerEntity,String> {
    ProjectManagerEntity findByProjectId(String id);

    ProjectManagerEntity findByUserAccountId(String id);
}
