package com.project.projectMgmtApp.team.controller;

import com.project.projectMgmtApp.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @GetMapping
    public ResponseEntity<?> getTeam(){
        return new ResponseEntity<>(teamService.getTeams(), HttpStatus.OK);
    }
}
