package com.dio.master.integrations.exceptions.handler;

import com.dio.master.infra.exceptions.ErrorResponse;
import com.dio.master.infra.exceptions.GlobalExceptionHandler;
import com.dio.master.integrations.exceptions.model.IntgrConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IntgrExcpHandler extends GlobalExceptionHandler {

    @ExceptionHandler(IntgrConnectionException.class)
    public ResponseEntity<ErrorResponse> handleIntegrationConnectException(IntgrConnectionException exception) {
        return buildErrorResponse(exception, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
