package com.trepudox.pessprof.presenter;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data @EqualsAndHashCode
public abstract class ResponsePresenter {

    private LocalDateTime dateTime = LocalDateTime.now();

}
