package com.example.myApp.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Such user does not exist!")
public class EntityNotFoundException extends RuntimeException {
}