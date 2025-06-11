package com.dio.master.app.exceptions.handlers;

import com.dio.master.app.exceptions.model.SerieNotFoundException;
import com.dio.master.infra.exceptions.ErrorResponse;
import com.dio.master.infra.exceptions.GlobalExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SeriesExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(SerieNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSerieNotFound(SerieNotFoundException exception) {
        return buildErrorResponse(exception, HttpStatus.NOT_FOUND);
    }
}