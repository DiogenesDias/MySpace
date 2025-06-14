package com.dio.master.integrations.configs.clients.services.omdb;

import com.dio.master.core.domain.model.Anime;
import com.dio.master.core.gateways.out.GatewayRetrieveAnime;
import com.dio.master.integrations.configs.clients.mappers.omdb.AnimesMapperIntegration;
import com.dio.master.integrations.configs.clients.params.omdb.OmdbParamsAnime;
import com.dio.master.integrations.configs.clients.requests.omdb.OmdbRequestAnime;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponse;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseAnime;
import com.dio.master.integrations.validators.omdb.ValidatorOmdb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OmdbServiceAnime implements GatewayRetrieveAnime {

    private final AnimesMapperIntegration animeMapper;
    private final List<ValidatorOmdb<OmdbResponse>> validators;

    @Override
    public Anime doRequest(String imdbID) {
        OmdbParamsAnime params = new OmdbParamsAnime(imdbID);
        OmdbRequestAnime request = new OmdbRequestAnime();
        OmdbResponseAnime response = request.requestObject(params);

        validators.forEach(validator -> validator.validate(response, imdbID));

        return animeMapper.toDomain(response);
    }
}
