package com.dio.master.integrations.configs.clients.responses.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbResponseSerie(
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
        , String totalSeasons
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
}