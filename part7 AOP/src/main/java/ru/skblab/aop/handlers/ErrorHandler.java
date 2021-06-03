package ru.skblab.aop.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.skblab.aop.exceptions.ExceedingRequestsException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ExceedingRequestsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String onExceedingRequestsException(ExceedingRequestsException exception){
        return exception.getMessage();
    }
}
