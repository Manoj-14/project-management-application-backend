package com.project.projectMgmtApp.task.service;

import com.project.projectMgmtApp.task.exceptions.TaskNotFoundException;
import com.project.projectMgmtApp.task.model.Task;
import com.project.projectMgmtApp.task.repository.TaskRepository;
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
    public Task getTeam(String id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id).stream().findFirst().orElse(null);
        if(task != null){
            return task;
        }
        else {
            throw new TaskNotFoundException("Team not Found");
        }
    }

    @Override
    public Task updateTeam(Task task) throws TaskNotFoundException {
        Task dbTask = taskRepository.findById(task.getId()).stream().findFirst().orElse(null);
        if(dbTask != null) taskRepository.save(task);
        else throw new TaskNotFoundException("Task not present in database");
        return null;
    }

    @Override
    public void deleteTeam(String id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id).stream().findFirst().orElse(null);
        if( task !=null) taskRepository.deleteById(id);
        else throw new TaskNotFoundException("Team not found");
    }
}
