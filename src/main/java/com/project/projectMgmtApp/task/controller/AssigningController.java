package com.project.projectMgmtApp.task.controller;

import com.project.projectMgmtApp.task.model.Assigned;
import com.project.projectMgmtApp.task.service.AssigningServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/assignment")
public class AssigningController {

    @Autowired
    private AssigningServiceImpl assigningService;

    @PostMapping
    public ResponseEntity<?> createAssignment(@RequestBody Map<String,String> requestBody){
        assigningService.createTaskAssignment(requestBody);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);

    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> getAssignmentByTask(@Valid @PathVariable String id){
        List<Assigned> assignments = assigningService.getAssignmentsByTaskId(id);
        return new ResponseEntity<>(assignments,HttpStatus.OK);
    }
}
