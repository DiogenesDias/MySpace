package com.dio.master.core.gateways.out;

import com.dio.master.app.validations.CheckImdbID;
import com.dio.master.core.domain.model.Episode;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface GatewayRetrieveAnimeEpisodes {

    List<Episode> doRequest(@CheckImdbID final String imdbID, final Integer season);
}