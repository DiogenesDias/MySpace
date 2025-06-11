package com.dio.master.app.usecases;

import com.dio.master.api.dto.responses.EpisodeResponse;
import com.dio.master.app.mappers.EpisodesMapper;
import com.dio.master.core.domain.model.Episode;
import com.dio.master.core.gateways.out.GatewayRetrieveAnimeEpisodes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsecaseFetchAnimeEpisodes {

    private final GatewayRetrieveAnimeEpisodes usecaseGateway;
    private final EpisodesMapper episodesMapper;

    public List<EpisodeResponse> execute(String imdbID, Integer season) {
        List<Episode> episodes = usecaseGateway.doRequest(imdbID, season);
        return episodesMapper.toResponseList(episodes);
    }
}
