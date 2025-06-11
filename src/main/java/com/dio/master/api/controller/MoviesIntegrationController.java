package com.dio.master.api.controller;

import com.dio.master.api.dto.responses.MovieResponse;
import com.dio.master.app.usecases.UsecaseFetchMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MoviesIntegrationController {

    private final UsecaseFetchMovies fetchMoviesUsecase;

    @GetMapping("/{imdbID}")
    public ResponseEntity<MovieResponse> fetchMovieByImdbID(@PathVariable String imdbID) {
        MovieResponse movieResponse = fetchMoviesUsecase.execute(imdbID);
        return ResponseEntity.status(HttpStatus.OK).body(movieResponse);
    }
}