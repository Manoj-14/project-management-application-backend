package com.project.projectMgmtApp.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "team_member")
public class TeamMember {

    @Id
    private String id;
    @DBRef
    private Team teamId;
    @DBRef
    private Employee employeeId;
    @DBRef
    private Role roleId;
}
