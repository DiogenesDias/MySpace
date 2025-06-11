package com.dio.master.api.dto.responses;

import java.util.List;

public record MovieResponse(
        String imdbID
        , String title
        , String runtime
        , String released
        , List<String> genres
        , List<String> directors
) {
}