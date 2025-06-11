package com.dio.master.api.dto.responses;

public record SerieResponse(
        String imdbID
        , String title
        , String seasons
        , String released
        , String yearsActive
) {
}