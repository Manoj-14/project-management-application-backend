package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.dto.TeamMemberDTO;
import com.project.projectMgmtApp.User.exceptions.TeamMemberNotFound;
import com.project.projectMgmtApp.User.model.TeamMember;
import com.project.projectMgmtApp.User.service.TeamMemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/teamMember")
public class TeamMemberController {
    @Autowired
    private TeamMemberService teamMemberService;


    @PostMapping
    public ResponseEntity<?> createTeamMember(@RequestBody TeamMemberDTO teamMemberDTO){

        TeamMember teamMember = teamMemberService.createTeamMember(teamMemberDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(teamMember.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeamMemberById(@PathVariable String id){
            TeamMember teamMember = teamMemberService.getTeamMemberById(id);
            return new ResponseEntity<>(teamMember,HttpStatus.OK);
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<?> getTeamMembersByTeamId(@PathVariable String id){
        List<TeamMember> teamMembers = teamMemberService.getTeamMembersByTeamId(id);
        return new ResponseEntity<>(teamMembers,HttpStatus.OK);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<?> getTeamMembersByRoleId(@PathVariable String id){
        List<TeamMember> teamMembers = teamMemberService.getTeamMembersByRoleId(id);
        return new ResponseEntity<>(teamMembers,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeamMember(@PathVariable String id){
            teamMemberService.deleteTeamMember(id);
            return ResponseEntity.accepted().build();
    }
}
