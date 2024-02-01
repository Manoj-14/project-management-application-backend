package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.exceptions.TeamNotFound;
import com.project.projectMgmtApp.User.model.Team;
import com.project.projectMgmtApp.User.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<?> createTeam(@RequestBody Team team){
        try {
            teamService.createTeam(team);
            return ResponseEntity.status(HttpStatus.CREATED).body("Team created Successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating team");
        }
    }

    @GetMapping("/get-all-teams")
    public ResponseEntity<?> getAllTeams(){
        return new ResponseEntity<>(teamService.getAllTeams(),HttpStatus.OK);
    }

    @GetMapping("/get-team/{id}")
    public ResponseEntity<?> getTeamById(@Valid @PathVariable String id){
        try {
            Team team = teamService.getTeamById(id);
            return new ResponseEntity<>(team,HttpStatus.OK);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateTeam(@Valid @RequestBody Team team, @PathVariable String id){
        if(id==null){
            throw new NullPointerException("Team id is null.");
        } else {
            team.setId(id);
        }
        try {
            Team savedTeam = teamService.updateTeam(team);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(team.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (TeamNotFound ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable String id){
        try {
            teamService.deleteTeam(id);
            return ResponseEntity.accepted().build();
        } catch (TeamNotFound e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
