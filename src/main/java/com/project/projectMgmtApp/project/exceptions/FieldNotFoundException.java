package com.project.projectMgmtApp.project.exceptions;

public class FieldNotFoundException extends RuntimeException{
    public FieldNotFoundException(String message){
        super(message);
    }
    public FieldNotFoundException(String message, Throwable cause){
        super(message);
    }
    public FieldNotFoundException(Throwable cause){
        super(cause);
    }
}
