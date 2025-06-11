package com.dio.master.infra.exceptions;

import lombok.Data;

import java.util.Map;

@Data
public class ErrorResponseFields {

    private String timestamp;
    private Integer status;
    private String error;
    private Map<String, String> fields;
}
