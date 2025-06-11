package com.dio.master.integrations.exceptions.handler;

import com.dio.master.infra.exceptions.ErrorResponse;
import com.dio.master.infra.exceptions.GlobalExceptionHandler;
import com.dio.master.integrations.exceptions.model.IntgrOmdbResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IntgrOmdbExcpHandler extends GlobalExceptionHandler {

    @ExceptionHandler(IntgrOmdbResponseException.class)
    public ResponseEntity<ErrorResponse> handleFieldsExceptions(IntgrOmdbResponseException exception) {
        return buildErrorResponse(exception, HttpStatus.BAD_REQUEST);
    }
}
