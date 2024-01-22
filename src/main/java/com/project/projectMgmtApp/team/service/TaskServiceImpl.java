package com.project.projectMgmtApp.team.service;

import com.project.projectMgmtApp.team.exceptions.TeamNotFoundException;
import com.project.projectMgmtApp.team.model.Task;
import com.project.projectMgmtApp.team.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> getTeams() {
        return taskRepository.findAll();
    }
    public Task createTeam(Task task){
        return taskRepository.save(task);
    }
    @Override
    public Task getTeam(String id) throws TeamNotFoundException {
        Task task = taskRepository.findById(id).stream().findFirst().orElse(null);
        if(task != null){
            return task;
        }
        else {
            throw new TeamNotFoundException("Team not Found");
        }
    }

    @Override
    public Task updateTeam(Task task) throws TeamNotFoundException {
        Task dbTask = taskRepository.findById(task.getId()).stream().findFirst().orElse(null);
        if(dbTask != null) taskRepository.save(task);
        else throw new TeamNotFoundException("Team not present in database");
        return null;
    }

    @Override
    public void deleteTeam(String id) throws TeamNotFoundException {
        Task task = taskRepository.findById(id).stream().findFirst().orElse(null);
        if( task !=null) taskRepository.deleteById(id);
        else throw new TeamNotFoundException("Team not found");
    }
}
