package com.project.projectMgmtApp.User.exceptions;

import com.project.projectMgmtApp.User.model.Team;

public class TeamNotFound extends RuntimeException{
    public TeamNotFound(String message){
        super(message);
    }
}
