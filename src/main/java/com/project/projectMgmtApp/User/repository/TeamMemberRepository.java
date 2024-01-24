package com.project.projectMgmtApp.User.repository;

import com.project.projectMgmtApp.User.model.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends MongoRepository<TeamMember,String> {
}
