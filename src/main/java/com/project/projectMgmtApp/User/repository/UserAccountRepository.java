package com.project.projectMgmtApp.User.repository;

import com.project.projectMgmtApp.User.model.UserAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount,String> {
}
