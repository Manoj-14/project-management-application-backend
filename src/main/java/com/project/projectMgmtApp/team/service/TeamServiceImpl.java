package com.project.projectMgmtApp.team.service;

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
}
