package com.dio.master.integrations.configs.clients.services.omdb;

import com.dio.master.core.domain.model.Episode;
import com.dio.master.core.gateways.out.GatewayRetrieveSerieEpisodes;
import com.dio.master.integrations.configs.clients.mappers.omdb.EpisodesMapperIntegration;
import com.dio.master.integrations.configs.clients.params.omdb.OmdbParamsEpisode;
import com.dio.master.integrations.configs.clients.requests.omdb.OmdbRequestEpisode;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponse;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseSeason;
import com.dio.master.integrations.validators.omdb.ValidatorOmdb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OmdbServiceSerieEpisodes implements GatewayRetrieveSerieEpisodes {

    private final EpisodesMapperIntegration episodeMapper;
    private final List<ValidatorOmdb<OmdbResponse>> validators;

    @Override
    public List<Episode> doRequest(String imdbID, Integer season) {
        OmdbParamsEpisode params = new OmdbParamsEpisode(imdbID, season);
        OmdbRequestEpisode request = new OmdbRequestEpisode();
        OmdbResponseSeason response = request.requestObject(params);

        validators.forEach(validator -> validator.validate(response, imdbID));

        return episodeMapper.toDomainList(response.Episodes(), season, imdbID);
    }
}