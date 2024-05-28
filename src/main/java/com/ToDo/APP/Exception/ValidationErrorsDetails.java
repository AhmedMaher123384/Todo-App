package com.ToDo.APP.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidationErrorsDetails {

    private String uri;
    private List<String> errors;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-mm-yyyy hh:mm:ss")
    private Date timeStamp;

    public ValidationErrorsDetails() {
        this.timeStamp=new Date();
        this.errors= new ArrayList<>();
    }

    public void addError(String error){
        this.errors.add(error);
    }


    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
