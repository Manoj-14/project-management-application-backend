package com.project.projectMgmtApp.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
public class Role {
    @Id
    private String id;
    private String roleName;
}
