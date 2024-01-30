package com.project.projectMgmtApp.User.controller;

import com.project.projectMgmtApp.User.model.Team;
import com.project.projectMgmtApp.User.service.TeamService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>("TeamId Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateTeam(@Valid @PathVariable String id){
        try {
            Team existingTeam = teamService.getTeamById(id);
            if (existingTeam == null){
                return new ResponseEntity<>("Team NOT Found with id:"+id,HttpStatus.NOT_FOUND);
            }
            teamService.updateTeam(existingTeam);
            return new ResponseEntity<>("Team Updated Successfully",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable String id){
        try {
            teamService.deleteTeam(id);
            return new ResponseEntity<>("Team deleted with id: "+id,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
