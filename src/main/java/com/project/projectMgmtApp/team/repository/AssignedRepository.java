package com.project.projectMgmtApp.team.repository;

import com.project.projectMgmtApp.team.model.Assigned;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignedRepository extends MongoRepository<Assigned,String> {

    List<Assigned> findAllByTeamId(String id);
}
