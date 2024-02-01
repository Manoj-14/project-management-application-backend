package com.project.projectMgmtApp.User.exceptions;

public class TeamMemberNotFound extends RuntimeException{
    public TeamMemberNotFound(String message){
        super(message);
    }
}
