package com.dio.master.app.usecases;

import com.dio.master.api.dto.responses.AnimeResponse;
import com.dio.master.app.mappers.AnimesMapper;
import com.dio.master.core.domain.model.Anime;
import com.dio.master.core.gateways.out.GatewayRetrieveAnime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsecaseFetchAnimes {

    private final GatewayRetrieveAnime usecaseGateway;
    private final AnimesMapper animesMapper;

    public AnimeResponse execute(String imdbID) {
        Anime anime = usecaseGateway.doRequest(imdbID);
        return animesMapper.toResponse(anime);
    }
}
