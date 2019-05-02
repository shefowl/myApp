package com.example.myApp.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<MyException> handleEntityNotFoundException() {
        return new ResponseEntity<>(new MyException(HttpStatus.NOT_FOUND, "Such user does not exist!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserListIsEmptyException.class)
    protected ResponseEntity<MyException> handleUserListIsEmptyException() {
        return new ResponseEntity<>(new MyException(HttpStatus.NOT_FOUND, "No one user has added yet!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SuchUserAlreadyExistException.class)
    protected ResponseEntity<MyException> handleSuchUserAlreadyExistException() {
        return new ResponseEntity<>(new MyException(HttpStatus.CONFLICT, "Such user is already exist! Please, choose another name."), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmptyCartException.class)
    protected ResponseEntity<MyException> handleEmptyCartException() {
        return new ResponseEntity<>(new MyException(HttpStatus.NOT_FOUND, "Your cart is empty."), HttpStatus.NOT_FOUND);
    }
}
