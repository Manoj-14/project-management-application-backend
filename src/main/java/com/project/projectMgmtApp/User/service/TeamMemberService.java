package com.project.projectMgmtApp.User.service;

import com.project.projectMgmtApp.User.model.Team;
import com.project.projectMgmtApp.User.model.TeamMember;

public interface TeamMemberService {
    public void createTeamMember(TeamMember teamMember);
    public TeamMember getTeamMemberById(String teamMemberId);
    public void deleteTeamMember(String teamMemberId);
}
