package com.project.projectMgmtApp.User.model;

import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "is required")
    @DBRef
    private Team teamId;
    @NotNull(message = "is required")
    @DBRef
    private Employee employeeId;
    @NotNull(message = "is required")
    @DBRef
    private Role roleId;
}
