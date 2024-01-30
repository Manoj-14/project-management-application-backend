package com.project.projectMgmtApp.User.service;

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
    public void updateTeam(Team team) {
        try {
            Optional<Team> existingTeamOptional = teamRepository.findById(team.getId());

            if(existingTeamOptional.isPresent()){
                Team existingTeam = existingTeamOptional.get();
                existingTeam.setTeamName(team.getTeamName());

                teamRepository.save(existingTeam);
            } else {
                throw new IllegalArgumentException("Team Not Found with ID :"+team.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeam(String teamId) {
        try {
            int id = Integer.parseInt(teamId);
            Optional<Team> existingTeamOptional = teamRepository.findById(String.valueOf(id));

            if(existingTeamOptional.isPresent()){
                teamRepository.deleteById(String.valueOf(id));
            } else {
                throw new IllegalArgumentException("Team NOT Found with ID:"+id);
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
