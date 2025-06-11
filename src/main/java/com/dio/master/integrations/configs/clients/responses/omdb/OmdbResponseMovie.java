package com.dio.master.integrations.configs.clients.responses.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbResponseMovie(
        String Title
        , String Year
        , String Rated
        , String Released
        , String Runtime
        , String Genre
        , String Director
        , String Writer
        , String Actors
        , String Plot
        , String Language
        , String Country
        , String Awards
        , String Poster
        , String Metascore
        , String imdbRating
        , String imdbVotes
        , String imdbID
        , String Type
        , String DVD
        , String BoxOffice
        , String Production
        , String Website
        , String Response
        , String Error
) implements OmdbResponse {

    @Override
    public String imdbIDRequested() {
        /**/
        return this.imdbID;
    }

    @Override
    public Boolean apiResponse() {
        /**/
        return !this.Response.equals("False");
    }

    @Override
    public String errorMessage() {
        /**/
        return this.Error;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Movie")
                .append("\n").append("Title").append("\t").append(Title)
                .append("\n").append("Year").append("\t").append(Year)
                .append("\n").append("Genre").append("\t").append(Genre)
                .append("\n").append("Director").append("\t").append(Director)
                .toString();
    }
}