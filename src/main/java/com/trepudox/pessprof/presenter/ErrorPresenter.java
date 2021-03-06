package com.trepudox.pessprof.presenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ErrorPresenter extends ResponsePresenter {

    private String error;
    private String message;
    private HttpStatus httpStatus;

}
