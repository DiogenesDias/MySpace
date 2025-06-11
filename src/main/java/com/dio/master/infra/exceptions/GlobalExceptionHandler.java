package com.dio.master.infra.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ElementKind;
import jakarta.validation.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {

    protected ResponseEntity<ErrorResponse> buildErrorResponse(RuntimeException exception, HttpStatus status) {

        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        response.setStatus(status.value());
        response.setError(status.getReasonPhrase());
        response.setMessage(exception.getMessage());

        return new ResponseEntity<>(response, status);
    }

    protected ResponseEntity<ErrorResponseFields> buildErrorResponseWithFields(ConstraintViolationException exception) {

        ErrorResponseFields response = new ErrorResponseFields();
        response.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setFields(extractFieldsErrors(exception));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    protected Map<String, String> extractFieldsErrors(ConstraintViolationException exception) {

        Map<String, String> mapErrors = new HashMap<>();
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String param = null;
            for (Path.Node node : violation.getPropertyPath()) {
                if (node.getKind() == ElementKind.PARAMETER) {
                    param = node.getName();
                    break;
                }
            }
            String message = violation.getMessage();
            mapErrors.put(param != null ? param : "Unknown", message);
        }
        return mapErrors;
    }
}