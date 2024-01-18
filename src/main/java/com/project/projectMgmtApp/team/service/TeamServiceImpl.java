package com.project.projectMgmtApp.team.service;

import com.project.projectMgmtApp.team.exceptions.TeamNotFoundException;
import com.project.projectMgmtApp.team.model.Team;
import com.project.projectMgmtApp.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;
    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
    public Team createTeam(Team team){
        return teamRepository.save(team);
    }
    @Override
    public Team getTeam(String id) throws TeamNotFoundException {
        Team team = teamRepository.findById(id).stream().findFirst().orElse(null);
        if(team != null){
            return team ;
        }
        else {
            throw new TeamNotFoundException("Team not Found");
        }
    }
}
