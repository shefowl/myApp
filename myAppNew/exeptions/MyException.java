package com.example.myApp.exeptions;

import org.springframework.http.HttpStatus;

public class MyException {
    private HttpStatus status;
    private String message;

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public MyException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
