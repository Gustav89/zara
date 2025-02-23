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
        else if(ex instanceof GeneralAspectException){
            GeneralAspectException g = (GeneralAspectException) ex;
            return new  ResponseEntity<>(getExceptionResponse(g.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(getExceptionResponse(ex.getMessage()),HttpStatus.NOT_FOUND);
    }


    private ExceptionResponse getExceptionResponse(String ex){
        ExceptionResponse e = new ExceptionResponse();
        e.setMessage(ex);
        return e;
    }
}
