package com.project.projectMgmtApp.task.service;

import com.project.projectMgmtApp.task.exceptions.TaskNotFoundException;
import com.project.projectMgmtApp.task.model.Task;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskService {

    public List<Task> getTeams();
    @Transactional
    public Task createTeam(Task task);
    public Task getTeam(String id) throws TaskNotFoundException;
    @Transactional
    public Task updateTeam(Task task) throws TaskNotFoundException;
    @Transactional
    public void deleteTeam(String id) throws TaskNotFoundException;
}
