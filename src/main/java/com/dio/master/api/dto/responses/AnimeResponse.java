package com.dio.master.api.dto.responses;

public record AnimeResponse(
        String imdbID
        , String title
        , String seasons
        , String released
        , String yearsActive
) {
}