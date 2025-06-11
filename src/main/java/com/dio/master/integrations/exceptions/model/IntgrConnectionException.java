package com.dio.master.integrations.exceptions.model;

public class IntgrConnectionException extends RuntimeException {

    public IntgrConnectionException() {
        /**/
        super("Server was Unavailable");
    }
}
