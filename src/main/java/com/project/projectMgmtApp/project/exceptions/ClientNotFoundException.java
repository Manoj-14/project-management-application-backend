package com.project.projectMgmtApp.project.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message){
        super(message);
    }public ClientNotFoundException(String message,Throwable cause){
        super(message,cause);
    }public ClientNotFoundException(Throwable cause){
        super(cause);
    }

}
