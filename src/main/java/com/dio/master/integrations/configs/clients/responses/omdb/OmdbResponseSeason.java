package com.dio.master.integrations.configs.clients.responses.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbResponseSeason(
        String Title
        , String Season
        , String totalSeasons
        , List<OmdbResponseEpisode> Episodes
        , String Response
        , String Error
) implements OmdbResponse {

    @Override
    public String imdbIDRequested() {
        return null;
    }

    @Override
    public Boolean apiResponse() {
        return !this.Response.equals("False");
    }

    @Override
    public String errorMessage() {
        return this.Error;
    }
}