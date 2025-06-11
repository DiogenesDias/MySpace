package com.dio.master.api.dto.responses;

public record EpisodeResponse(
        String title
        , String season
        , String number
        , String released
        , String ownerID
) {
}