package com.project.projectMgmtApp.project.exceptions;

public class ProjectManagerNotFoundException extends RuntimeException{
    public ProjectManagerNotFoundException(String message){
        super(message);
    }
    public ProjectManagerNotFoundException(String message,Throwable cause){
        super(message);
    }
    public ProjectManagerNotFoundException(Throwable cause){
        super(cause);
    }
}
