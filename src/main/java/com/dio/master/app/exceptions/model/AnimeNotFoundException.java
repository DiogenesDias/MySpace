package com.dio.master.app.exceptions.model;

public class AnimeNotFoundException extends RuntimeException {

    public AnimeNotFoundException(String imdbID) {
        /**/
        super("Anime with imdbID " + imdbID + " not found.");
    }
}
