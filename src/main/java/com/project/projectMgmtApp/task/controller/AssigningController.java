package com.project.projectMgmtApp.task.controller;

import com.project.projectMgmtApp.task.dto.AssignmentDTO;
import com.project.projectMgmtApp.task.model.Assignment;
import com.project.projectMgmtApp.task.service.AssigningServiceImpl;
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
@RequestMapping("api/assignment")
public class AssigningController {

    @Autowired
    private AssigningServiceImpl assigningService;

    @PostMapping
    public ResponseEntity<?> createAssignment(@RequestBody AssignmentDTO assignmentDTO) {
        Assignment savedAssignment = assigningService.createTaskAssignment(assignmentDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAssignment.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> getAssignmentByTask(@Valid @PathVariable String id) {
        List<Assignment> assignments = assigningService.getAssignmentsByTaskId(id);
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAssignment(@PathVariable String id) {
        Assignment assignment = assigningService.getAssigned(id);
        return new ResponseEntity<>(assignment, HttpStatus.OK);
    }

    @PutMapping("/demoUpdate")
    public ResponseEntity<?> updateAssignment(@RequestBody AssignmentDTO assignmentDTO) {
        return new ResponseEntity<>(assigningService.demoUpdate(assignmentDTO),HttpStatus.OK);
    }

}
