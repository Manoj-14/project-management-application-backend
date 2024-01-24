package com.project.projectMgmtApp.User.repository;

import com.project.projectMgmtApp.User.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String> {
}
