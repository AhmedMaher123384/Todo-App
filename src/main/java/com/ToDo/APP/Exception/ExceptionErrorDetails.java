package com.ToDo.APP.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ExceptionErrorDetails {


        private String message;
        private String uri;
        @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd-mm-yyyy hh:mm:ss")
        private Date timeStamp;

    public ExceptionErrorDetails() {
        this.timeStamp=new Date();
    }

    public ExceptionErrorDetails(String message, String uri) {
        this();
        this.message = message;
        this.uri = uri;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
