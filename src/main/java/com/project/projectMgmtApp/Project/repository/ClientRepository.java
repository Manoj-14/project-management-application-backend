package com.project.projectMgmtApp.Project.repository;

import com.project.projectMgmtApp.Project.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity,String> {
}
