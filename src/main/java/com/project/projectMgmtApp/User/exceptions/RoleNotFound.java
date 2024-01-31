package com.project.projectMgmtApp.User.exceptions;

public class RoleNotFound extends RuntimeException{
    public RoleNotFound(String message){
        super(message);
    }
}
