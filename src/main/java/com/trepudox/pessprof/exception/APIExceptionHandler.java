package com.trepudox.pessprof.exception;

import com.trepudox.pessprof.presenter.ErrorPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorPresenter> handleException(Exception exception) {
        LocalDateTime dateTime = LocalDateTime.now();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = exception.getMessage();

        ErrorPresenter errorPresenter = new ErrorPresenter(dateTime, httpStatus, message);

        exception.printStackTrace();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorPresenter);
    }

}
