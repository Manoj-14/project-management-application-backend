package com.project.projectMgmtApp.User.repository;

import com.project.projectMgmtApp.User.model.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamMemberRepository extends MongoRepository<TeamMember,String> {
}
