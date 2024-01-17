package com.project.projectMgmtApp.team.service;

import com.project.projectMgmtApp.team.model.Team;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeamService {

    public List<Team> getTeams();

    @Transactional
    public Team createTeam(Team team);
}
