package com.dio.master.app.exceptions.model;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String imdbID) {
        /**/
        super("Movie with imdbID " + imdbID + " not found.");
    }
}
