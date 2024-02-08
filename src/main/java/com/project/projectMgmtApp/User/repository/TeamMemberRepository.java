package com.project.projectMgmtApp.User.repository;

import com.project.projectMgmtApp.User.model.Team;
import com.project.projectMgmtApp.User.model.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends MongoRepository<TeamMember,String> {
    public List<TeamMember> findAllByTeamId(String id);
    public List<TeamMember> findAllByRoleId(String id);
}
