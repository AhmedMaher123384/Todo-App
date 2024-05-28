package com.ToDo.APP.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ExceptionErrorDetails> handleExceptions(ApiBaseException ex , WebRequest request){

            ExceptionErrorDetails error = new ExceptionErrorDetails(ex.getMessage(),request.getDescription(false));
            return  new ResponseEntity<>(error,ex.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ValidationErrorsDetails validationErrors = new ValidationErrorsDetails();
        validationErrors.setUri(request.getDescription(false));
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError f : fieldErrors){
            validationErrors.addError(f.getDefaultMessage());
        }
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

}
