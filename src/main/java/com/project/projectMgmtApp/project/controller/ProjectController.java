package com.project.projectMgmtApp.project.controller;

import com.project.projectMgmtApp.project.entity.ProjectEntity;
import com.project.projectMgmtApp.project.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
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
    public ResponseEntity<?> addProject(@RequestBody Map<String, String> projectEntity){
            ProjectEntity project = projectService.addProject(projectEntity);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(project.getId()).toUri();
            return ResponseEntity.created(location).build();

    }

    @GetMapping
    public ResponseEntity<?> getProjects(){
        List<ProjectEntity> project = projectService.getProject();
        return new ResponseEntity<>(project,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateProject(@RequestBody Map<String, String> projectEntity){
        ProjectEntity project = projectService.updateProject(projectEntity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(project.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable String id){
        ProjectEntity project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable String id){
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> deleteProjectByClientId(@PathVariable String id){
        List<ProjectEntity> projectEntities = projectService.getProjectByClientId(id);
        return new ResponseEntity<>(projectEntities,HttpStatus.OK);
    }
}
