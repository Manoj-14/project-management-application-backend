package com.project.projectMgmtApp.exceptions;
import com.project.projectMgmtApp.project.exceptions.ClientNotFoundException;
import com.project.projectMgmtApp.project.exceptions.ProjectNotFoundException;
import com.project.projectMgmtApp.team.exceptions.TeamNotFoundException;
import com.project.projectMgmtApp.util.ErrorDetail;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizedResponseException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetail> handleAllException(Exception ex, WebRequest request) throws Exception{
        ErrorDetail errorDetail = new ErrorDetail(LocalDate.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TeamNotFoundException.class)
    public final ResponseEntity<ErrorDetail> handleTeamNotFoundException(Exception ex,WebRequest request) throws Exception {
        ErrorDetail errorDetail = new ErrorDetail(LocalDate.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public final ResponseEntity<ErrorDetail> handleAssignValueNotFound(Exception ex, WebRequest request) throws Exception {
        ErrorDetail errorDetail = new ErrorDetail(LocalDate.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorDetail>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDetail errorDetail = new ErrorDetail(LocalDate.now(),"Total Errors:"+ex.getErrorCount()+" First Error " +ex.getFieldError().getDefaultMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetail,HttpStatus.BAD_REQUEST);
    }

    //Client Not found exception
    @ExceptionHandler(ClientNotFoundException.class)
    public final ResponseEntity<ErrorDetail> handleClientNotFoundException(Exception exc,WebRequest request) throws Exception{
        ErrorDetail error = new ErrorDetail();

        error.setDetails(request.getDescription(false));
        error.setMessage((exc.getMessage()));
        error.setTimeStamp(LocalDate.now());
        System.out.println("Custom Exception"+error);
        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Project Not found exception
    @ExceptionHandler(ProjectNotFoundException.class)
    public final ResponseEntity<ErrorDetail> handleProjectNotFoundException(Exception exc,WebRequest request) throws Exception{

        ErrorDetail error = new ErrorDetail();

        error.setDetails(request.getDescription(false));
        error.setMessage((exc.getMessage()));
        error.setTimeStamp(LocalDate.now());
        System.out.println("Custom Exception"+error);
        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
