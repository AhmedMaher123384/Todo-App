package com.ToDo.APP.Exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiBaseException{
    public NotFoundException(String message) {
        super(message);
    }

    HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
