package ru.skblab.aop.exceptions;

public class ExceedingRequestsException extends Exception{

    public ExceedingRequestsException(String message){
        super(message);
    }
}
