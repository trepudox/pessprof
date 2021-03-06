package com.trepudox.pessprof.exception;

import com.trepudox.pessprof.presenter.ErrorPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorPresenter> handleException(Exception exception) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String error = exception.getClass().getSimpleName().replace("Exception", "");
        String message = exception.getMessage();

        ErrorPresenter errorPresenter = new ErrorPresenter(error, message, httpStatus);

        exception.printStackTrace();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorPresenter);
    }

}
