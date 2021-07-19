package com.trepudox.pessprof.presenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class ErrorPresenter {

    private LocalDateTime dateTime;
    private HttpStatus httpStatus;
    private String error;
    private String message;

}
