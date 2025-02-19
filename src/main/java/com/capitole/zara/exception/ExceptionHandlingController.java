package com.capitole.zara.exception;

import com.capitole.zara.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleError(Exception ex){
        if(ex instanceof NoPriceExistException){
            NoPriceExistException s = (NoPriceExistException) ex;
            return new  ResponseEntity<>(getExceptionResponse(s.getMessage()),HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ofNullable(getExceptionResponse(ex.getMessage()));
    }


    private ExceptionResponse getExceptionResponse(String ex){
        ExceptionResponse e = new ExceptionResponse();
        e.setMessage(ex);
        return e;
    }
}
