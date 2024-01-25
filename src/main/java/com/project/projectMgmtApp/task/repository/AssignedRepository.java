package com.project.projectMgmtApp.task.repository;

import com.project.projectMgmtApp.task.model.Assigned;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignedRepository extends MongoRepository<Assigned,String> {

    List<Assigned> findAllByTaskId(String id);

}
