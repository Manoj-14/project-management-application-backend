package com.project.projectMgmtApp.User.exceptions;

public class UserAccountNotFound extends RuntimeException{
    public UserAccountNotFound(String message){
        super(message);
    }
}
