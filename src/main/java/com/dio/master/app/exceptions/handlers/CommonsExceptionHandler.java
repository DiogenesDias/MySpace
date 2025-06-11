package com.dio.master.app.exceptions.handlers;

import com.dio.master.infra.exceptions.ErrorResponseFields;
import com.dio.master.infra.exceptions.GlobalExceptionHandler;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonsExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseFields> handleFieldsExceptions(ConstraintViolationException exception) {
        return buildErrorResponseWithFields(exception);
    }
}
