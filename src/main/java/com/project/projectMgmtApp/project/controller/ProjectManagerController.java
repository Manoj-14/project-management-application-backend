package com.project.projectMgmtApp.project.controller;

import com.project.projectMgmtApp.project.entity.ProjectManagerEntity;
import com.project.projectMgmtApp.project.service.ProjectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projectManager")
public class ProjectManagerController {

    private ProjectManagerService projectManagerService;

    @Autowired
    public ProjectManagerController(ProjectManagerService projectManagerService){
        this.projectManagerService = projectManagerService;
    }

    @PostMapping
    public ResponseEntity<?> addProjectManager(@RequestBody  Map<String,String> requestBody){

        ProjectManagerEntity projectManager = projectManagerService.addProjectManager(requestBody);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(projectManager.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<?> updateProjectManager(@RequestBody  Map<String,String> requestBody){
        ProjectManagerEntity projectManager = projectManagerService.updateProjectManager(requestBody);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(projectManager.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<?> getProjectManager(){
        List<ProjectManagerEntity> projectManager = projectManagerService.getProjectManager();
        return new ResponseEntity<>(projectManager, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectManagerById(@PathVariable String id){
        ProjectManagerEntity projectManager = projectManagerService.getProjectManagerById(id);
        return new ResponseEntity<>(projectManager,HttpStatus.OK);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<?> getProjectManagerByProjectId(@PathVariable String id){
        ProjectManagerEntity projectManager = projectManagerService.getProjectManagerByProjectId(id);
        return new ResponseEntity<>(projectManager,HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getProjectManagerByUserId(@PathVariable String id){
        ProjectManagerEntity projectManager = projectManagerService.getProjectManagerByUserAccountId(id);
        return new ResponseEntity<>(projectManager,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjectManager(@PathVariable String id){
        projectManagerService.deleteProjectManager(id);
        return ResponseEntity.ok().build();
    }
}
