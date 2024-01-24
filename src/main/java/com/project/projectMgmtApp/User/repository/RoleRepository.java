package com.project.projectMgmtApp.User.repository;

import com.project.projectMgmtApp.User.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {
}
