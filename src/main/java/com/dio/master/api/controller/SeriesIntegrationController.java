package com.dio.master.api.controller;

import com.dio.master.api.dto.responses.EpisodeResponse;
import com.dio.master.api.dto.responses.SerieResponse;
import com.dio.master.app.usecases.UsecaseFetchSerieEpisodes;
import com.dio.master.app.usecases.UsecaseFetchSeries;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/series")
public class SeriesIntegrationController {

    private final UsecaseFetchSeries fetchSeriesUsecase;
    private final UsecaseFetchSerieEpisodes fetchSerieEpisodesUsecase;

    @GetMapping("/{imdbID}")
    public ResponseEntity<SerieResponse> fetchSeriesByImdbID(@PathVariable String imdbID) {
        SerieResponse serieResponse = fetchSeriesUsecase.execute(imdbID);
        return ResponseEntity.status(HttpStatus.OK).body(serieResponse);
    }

    @GetMapping("/{imdbID}/season/{season}")
    public ResponseEntity<List<EpisodeResponse>> fetchSerieEpisodesByImdbID(@PathVariable String imdbID, @PathVariable Integer season) {
        List<EpisodeResponse> episodesReponse = fetchSerieEpisodesUsecase.execute(imdbID, season);
        return ResponseEntity.status(HttpStatus.OK).body(episodesReponse);
    }
}