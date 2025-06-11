package com.dio.master.infra.exceptions;

import lombok.Data;

import java.util.Map;

@Data
public class ErrorResponse {

    private String timestamp;
    private Integer status;
    private String error;
    private String message;
}
