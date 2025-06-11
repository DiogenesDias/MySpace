package com.dio.master.app.usecases;

import com.dio.master.api.dto.responses.MovieResponse;
import com.dio.master.app.mappers.MoviesMapper;
import com.dio.master.core.domain.model.Movie;
import com.dio.master.core.gateways.out.GatewayRetrieveMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsecaseFetchMovies {

    private final GatewayRetrieveMovies usecaseGateway;
    private final MoviesMapper moviesMapper;

    public MovieResponse execute(String imdbID) {
        Movie movie = usecaseGateway.doRequest(imdbID);
        return moviesMapper.toResponse(movie);
    }
}
