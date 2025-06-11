package com.dio.master.app.exceptions.handlers;

import com.dio.master.app.exceptions.model.MovieNotFoundException;
import com.dio.master.infra.exceptions.ErrorResponse;
import com.dio.master.infra.exceptions.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MoviesExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMovieNotFound(MovieNotFoundException exception) {
        return buildErrorResponse(exception, HttpStatus.NOT_FOUND);
    }
}