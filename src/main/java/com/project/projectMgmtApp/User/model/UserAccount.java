package com.project.projectMgmtApp.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_account")
public class UserAccount {

    @Id
    private String id;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean isProjectManager;
    private LocalDateTime registrationTime;
}
