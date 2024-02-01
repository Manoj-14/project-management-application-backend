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
        try {
            teamMemberService.createTeamMember(teamMember);
            return ResponseEntity.status(HttpStatus.CREATED).body("TeamMember Created.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating TeamMember.");
        }
    }

    @GetMapping("/get-team-member/{id}")
    public ResponseEntity<?> getTeamMemberById(@Valid @PathVariable String id){
        try {
            TeamMember teamMember = teamMemberService.getTeamMemberById(id);
            return new ResponseEntity<>(teamMember,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("TeamMemberId Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable String id){
        try {
            teamMemberService.deleteTeamMember(id);
            return ResponseEntity.accepted().build();
        } catch (TeamMemberNotFound e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
