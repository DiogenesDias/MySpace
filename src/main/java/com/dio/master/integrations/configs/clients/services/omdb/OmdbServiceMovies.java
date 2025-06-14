package com.dio.master.integrations.configs.clients.services.omdb;

import com.dio.master.core.domain.model.Movie;
import com.dio.master.core.gateways.out.GatewayRetrieveMovies;
import com.dio.master.integrations.configs.clients.mappers.omdb.MoviesMapperIntegration;
import com.dio.master.integrations.configs.clients.params.omdb.OmdbParamsMovie;
import com.dio.master.integrations.configs.clients.requests.omdb.OmdbRequestMovie;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponse;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseMovie;
import com.dio.master.integrations.validators.omdb.ValidatorOmdb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OmdbServiceMovies implements GatewayRetrieveMovies {

    private final MoviesMapperIntegration movieMapper;
    private final List<ValidatorOmdb<OmdbResponse>> validators;

    @Override
    public Movie doRequest(String imdbID) {
        OmdbParamsMovie params = new OmdbParamsMovie(imdbID);
        OmdbRequestMovie request = new OmdbRequestMovie();
        OmdbResponseMovie response = request.requestObject(params);

        validators.forEach(validator -> validator.validate(response, imdbID));

        return movieMapper.toDomain(response);
    }
}
