package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.dto.TeamMemberDTO;
import com.project.projectMgmtApp.User.model.Team;
import com.project.projectMgmtApp.User.model.TeamMember;

import java.util.List;

public interface TeamMemberService {
    public TeamMember createTeamMember(TeamMemberDTO teamMemberDTO);
    public TeamMember getTeamMemberById(String teamMemberId);
    public List<TeamMember> getTeamMembersByTeamId(String teamId);
    public List<TeamMember> getTeamMembersByRoleId(String roleId);
    public void deleteTeamMember(String teamMemberId);
}
