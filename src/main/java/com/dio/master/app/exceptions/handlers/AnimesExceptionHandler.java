package com.dio.master.app.exceptions.handlers;

import com.dio.master.app.exceptions.model.AnimeNotFoundException;
import com.dio.master.infra.exceptions.ErrorResponse;
import com.dio.master.infra.exceptions.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AnimesExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(AnimeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAnimeNotFound(AnimeNotFoundException exception) {
        return buildErrorResponse(exception, HttpStatus.NOT_FOUND);
    }
}