package com.project.projectMgmtApp.User.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "team")
public class Team {
    @Id
    private String id;

    @NotNull(message = "is required")
    private String teamName;
}
