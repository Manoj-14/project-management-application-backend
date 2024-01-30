package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.Team;
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
    public void deleteTeamMember(String teamMemberId) {
        try {
            int id = Integer.parseInt(teamMemberId);
            Optional<TeamMember> existingTeamMemeberOptional = teamMemberRepository.findById(String.valueOf(id));

            if(existingTeamMemeberOptional.isPresent()){
                teamMemberRepository.deleteById(String.valueOf(id));
            } else {
                throw  new IllegalArgumentException("TeamMember Not Found id:"+id);
            }
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
