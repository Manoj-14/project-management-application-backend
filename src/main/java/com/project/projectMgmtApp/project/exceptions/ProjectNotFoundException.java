package com.project.projectMgmtApp.project.exceptions;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(String message){
        super(message);
    }
    public ProjectNotFoundException(String message, Throwable cause){
        super(message);
    }
    public ProjectNotFoundException(Throwable cause){
        super(cause);
    }
}
