package com.ToDo.APP.Exception;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseException extends RuntimeException {

    public ApiBaseException(String message) {
        super(message);
    }
    abstract HttpStatus getHttpStatus();
}
