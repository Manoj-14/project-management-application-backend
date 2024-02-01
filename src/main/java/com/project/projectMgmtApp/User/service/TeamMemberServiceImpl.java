package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.exceptions.TeamMemberNotFound;
import com.project.projectMgmtApp.User.model.TeamMember;
import com.project.projectMgmtApp.User.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamMemberServiceImpl implements TeamMemberService{

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Override
    public void createTeamMember(TeamMember teamMember) {
        teamMemberRepository.save(teamMember);
    }

    @Override
    public TeamMember getTeamMemberById(String teamMemberId) {
        Optional<TeamMember> optionalTeamMember = teamMemberRepository.findById(String.valueOf(Integer.parseInt(teamMemberId)));
        return optionalTeamMember.orElse(null);
    }

    @Override
    public void deleteTeamMember(String teamMemberId) throws TeamMemberNotFound {
        TeamMember teamMember = teamMemberRepository.findById(teamMemberId).stream().findFirst().orElse(null);
        if(teamMember != null) teamMemberRepository.deleteById(teamMemberId);
        else throw new TeamMemberNotFound("TeamMember not found");
    }
}
