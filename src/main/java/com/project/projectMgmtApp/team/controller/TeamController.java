package com.project.projectMgmtApp.team.controller;

import com.project.projectMgmtApp.team.exceptions.TeamNotFoundException;
import com.project.projectMgmtApp.team.model.Team;
import com.project.projectMgmtApp.team.service.TeamService;
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
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping
    public ResponseEntity<?> getTeam(){
        return new ResponseEntity<>(teamService.getTeams(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTeam(@Valid Team team) {
        try{
            Team savedTeam = teamService.createTeam(team);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTeam.getId()).toUri();
            return ResponseEntity.created(location).build();
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeam(@Valid @PathVariable String id){
        try{
            Team team = teamService.getTeam(id);
            return new ResponseEntity<>(team,HttpStatus.OK);
        }catch (TeamNotFoundException ex){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
