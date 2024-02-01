package com.project.projectMgmtApp.User.exceptions;

public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(String message){
        super(message);
    }
}
