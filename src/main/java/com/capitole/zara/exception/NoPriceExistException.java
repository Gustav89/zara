package com.capitole.zara.exception;

public class NoPriceExistException extends  Exception{
    public NoPriceExistException(String errorMessage){
        super(errorMessage);
    }
}
