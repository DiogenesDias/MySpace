package com.dio.master.api.controller;

import com.dio.master.api.dto.responses.AnimeResponse;
import com.dio.master.api.dto.responses.EpisodeResponse;
import com.dio.master.app.usecases.UsecaseFetchAnimeEpisodes;
import com.dio.master.app.usecases.UsecaseFetchAnimes;
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
@RequestMapping("/animes")
public class AnimesIntegrationController {

    private final UsecaseFetchAnimes fetchAnimesUsercase;
    private final UsecaseFetchAnimeEpisodes fetchAnimeEpisodesUsecase;

    @GetMapping("/{imdbID}")
    public ResponseEntity<AnimeResponse> fetchAnimeByImdbID(@PathVariable String imdbID) {
        AnimeResponse animeResponse = fetchAnimesUsercase.execute(imdbID);
        return ResponseEntity.status(HttpStatus.OK).body(animeResponse);
    }

    @GetMapping("/{imdbID}/season/{season}")
    public ResponseEntity<List<EpisodeResponse>> fetchAnimeEpisodesByImdbID(@PathVariable String imdbID, @PathVariable Integer season) {
        List<EpisodeResponse> episodesReponse = fetchAnimeEpisodesUsecase.execute(imdbID, season);
        return ResponseEntity.status(HttpStatus.OK).body(episodesReponse);
    }
}