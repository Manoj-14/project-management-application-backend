package com.project.projectMgmtApp.team.repository;

import com.project.projectMgmtApp.team.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
