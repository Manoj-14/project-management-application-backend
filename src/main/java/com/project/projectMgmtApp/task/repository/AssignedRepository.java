package com.project.projectMgmtApp.task.repository;

import com.project.projectMgmtApp.task.model.Assignment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignedRepository extends MongoRepository<Assignment,String> {

    List<Assignment> findAllByTaskId(String id);

}
