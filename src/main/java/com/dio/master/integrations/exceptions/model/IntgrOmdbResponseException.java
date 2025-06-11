package com.dio.master.integrations.exceptions.model;

public class IntgrOmdbResponseException extends RuntimeException {

    public IntgrOmdbResponseException(String imdbID) {
        /**/
        super("Object with imdbID " + imdbID + " Not Found On Omdb Server.");
    }
}
