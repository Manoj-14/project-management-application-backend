package com.project.projectMgmtApp.User.repository;

import com.project.projectMgmtApp.User.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team,String> {
}
