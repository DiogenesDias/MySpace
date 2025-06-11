package com.dio.master.infra.resources.messages;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@Accessors(fluent = true)
public class PropMessagesOmdb {

    @Value("${message.omdb.error.bad-request}")
    private String messageErrorBadRequest;

    @Value("${message.omdb.error.params-invalid}")
    private String messageErrorParamsInvalid;

    @Value("${message.omdb.error.response.invalid-type}")
    private String messageErrorResponseInvalidType;

    @Value("${message.omdb.error.params-missing.imdbID}")
    private String messageErrorParamsMissingImdbID;

    @Value("${message.omdb.error.params-missing.season")
    private String messageErrorParamsMissingSeason;

    @Value("${message.omdb.error.anime.not-found.by-ImdbID}")
    private String messageErrorAnimeNotFoundByImdbID;

    @Value("${message.omdb.error.serie.not-found.by-ImdbID}")
    private String messageErrorSerieNotFoundByImdbID;

    @Value("${message.omdb.error.movie.not-found.by-ImdbID}")
    private String messageErrorMovieNotFoundByImdbID;
}