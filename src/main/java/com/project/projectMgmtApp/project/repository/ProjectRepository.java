package com.project.projectMgmtApp.project.repository;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import com.project.projectMgmtApp.project.entity.ProjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends MongoRepository<ProjectEntity,String> {
   List<ProjectEntity> findAllByClientId(String id);
}
