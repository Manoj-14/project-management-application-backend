package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.exceptions.TeamMemberNotFound;
import com.project.projectMgmtApp.User.model.TeamMember;
import com.project.projectMgmtApp.User.service.TeamMemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/team-member")
public class TeamMemberController {
    @Autowired
    private TeamMemberService teamMemberService;

    @PostMapping("/create")
    public ResponseEntity<?> createTeamMember(@RequestBody TeamMember teamMember){

            teamMemberService.createTeamMember(teamMember);
            return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/get-team-member/{id}")
    public ResponseEntity<?> getTeamMemberById(@Valid @PathVariable String id){

            TeamMember teamMember = teamMemberService.getTeamMemberById(id);
            return new ResponseEntity<>(teamMember,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable String id){

            teamMemberService.deleteTeamMember(id);
            return ResponseEntity.accepted().build();

    }
}
