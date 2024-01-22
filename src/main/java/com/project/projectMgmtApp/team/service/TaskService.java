package com.project.projectMgmtApp.team.service;

import com.project.projectMgmtApp.team.exceptions.TeamNotFoundException;
import com.project.projectMgmtApp.team.model.Task;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskService {

    public List<Task> getTeams();
    @Transactional
    public Task createTeam(Task task);
    public Task getTeam(String id) throws TeamNotFoundException;
    @Transactional
    public Task updateTeam(Task task) throws TeamNotFoundException;
    @Transactional
    public void deleteTeam(String id) throws TeamNotFoundException;
}
