package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.Employee;
import com.project.projectMgmtApp.User.model.Team;

import java.util.List;

public interface TeamService {
    public Team createTeam(Team team);

    public Team getTeamById(String teamId);

    List<Team> getAllTeams();

    public Team updateTeam(Team team);

    public void deleteTeam(String teamId);
}
