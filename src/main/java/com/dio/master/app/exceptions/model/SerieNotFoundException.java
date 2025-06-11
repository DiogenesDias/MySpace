package com.dio.master.app.exceptions.model;

public class SerieNotFoundException extends RuntimeException {

    public SerieNotFoundException(String imdbID) {
        /**/
        super("Serie with imdbID " + imdbID + " not found.");
    }
}
