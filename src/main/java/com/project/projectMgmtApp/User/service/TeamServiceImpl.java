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
        Optional<Team> optionalTeam = teamRepository.findById(String.valueOf(Integer.parseInt(teamId)));
        return optionalTeam.orElse(null);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(Team team) throws TeamNotFound{
        Team dbTeam = teamRepository.findById(team.getId()).stream().findFirst().orElse(null);
        if(dbTeam != null) teamRepository.save(team);
        else throw new TeamNotFound("Team not found");
        return null;
    }

    @Override
    public void deleteTeam(String teamId) throws TeamNotFound {
        Team team = teamRepository.findById(teamId).stream().findFirst().orElse(null);
        if(team != null) teamRepository.deleteById(teamId);
        else throw new TeamNotFound("Team not found");
    }
}
