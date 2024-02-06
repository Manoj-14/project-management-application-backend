package com.project.projectMgmtApp.User.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_account")
public class UserAccount {

    @Id
    private String id;

    @NotNull(message = "is required")
    private String username;
    @NotNull(message = "is required")
    private String password;
    @NotNull(message = "is required")
    private String email;
    @NotNull(message = "is required")
    private String firstName;
    @NotNull(message = "is required")
    private String lastName;
    @NotNull(message = "is required")
    private boolean isProjectManager;
    @NotNull(message = "is required")
    private LocalDate registrationTime;

    public UserAccount(String id) {
        this.id = id;
    }
}
