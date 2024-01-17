package com.project.projectMgmtApp.team.repository;

import com.project.projectMgmtApp.team.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, Integer> {
}
