package com.project.projectMgmtApp.project.controller;

import com.project.projectMgmtApp.project.entity.ProjectEntity;
import com.project.projectMgmtApp.project.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<?> addProject(Map<String, String> projectEntity){
        System.out.println(projectEntity);
        try{
            ProjectEntity project = projectService.addProject(projectEntity);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(project.getId()).toUri();
            return ResponseEntity.created(location).build();

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
