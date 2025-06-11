package com.dio.master.integrations.configs.clients.responses.omdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OmdbResponseEpisode(
        String Title
        , String Released
        , String Episode
        , String imdbRating
        , String imdbID
) {
}