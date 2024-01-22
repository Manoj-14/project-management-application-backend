package com.project.projectMgmtApp.project.repository;

import com.project.projectMgmtApp.project.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity,String> {
    boolean existsById(String id);
}
