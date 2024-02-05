package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.exceptions.TeamNotFound;
import com.project.projectMgmtApp.User.model.Team;
import com.project.projectMgmtApp.User.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;
    @Override
    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public Team getTeamById(String teamId) {
        Team optionalTeam = teamRepository.findById(teamId).stream().findFirst().orElse(null);
        if(optionalTeam != null){
            return optionalTeam;
        }
        else {
            throw new TeamNotFound("Team not found");
        }
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(Team team){
        Team dbTeam = teamRepository.findById(team.getId()).stream().findFirst().orElse(null);
        if(dbTeam != null) return teamRepository.save(team);
        else throw new TeamNotFound("Team not found");
    }

    @Override
    public void deleteTeam(String teamId) {
        Team team = teamRepository.findById(teamId).stream().findFirst().orElse(null);
        if(team != null) teamRepository.deleteById(teamId);
        else throw new TeamNotFound("Team not found");
    }
}
