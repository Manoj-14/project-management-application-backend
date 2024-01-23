package com.project.projectMgmtApp.task.controller;

import com.project.projectMgmtApp.task.exceptions.TeamNotFoundException;
import com.project.projectMgmtApp.task.model.Task;
import com.project.projectMgmtApp.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/teams")
public class TaskController {
    @Autowired
    private TaskService teamService;
    @GetMapping
    public ResponseEntity<?> getTeam(){
        return new ResponseEntity<>(teamService.getTeams(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTeam(@Valid @RequestBody Task task) {
        try{
            Task savedTask = teamService.createTeam(task);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTask.getId()).toUri();
            return ResponseEntity.created(location).build();
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeam(@Valid @PathVariable String id){
        try{
            Task task = teamService.getTeam(id);
            return new ResponseEntity<>(task,HttpStatus.OK);
        }catch (TeamNotFoundException ex){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@Valid @RequestBody Task task, @PathVariable String id){
        if(id== null){
            throw new NullPointerException("Team ID is Null");
        }else{
            task.setId(id);
        }
        try{
            Task savedTask = teamService.updateTeam(task);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
            return ResponseEntity.created(location).build();
        }catch (TeamNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable String id){
        try{
            teamService.deleteTeam(id);
            return ResponseEntity.accepted().build();
        }catch (TeamNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
