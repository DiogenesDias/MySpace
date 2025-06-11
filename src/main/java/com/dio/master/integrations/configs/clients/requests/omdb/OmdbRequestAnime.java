package com.dio.master.integrations.configs.clients.requests.omdb;

import com.dio.master.integrations.configs.IntegrationsParams;
import com.dio.master.integrations.configs.IntegrationsService;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseAnime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OmdbRequestAnime extends IntegrationsService<OmdbResponseAnime> {

    @Override
    public OmdbResponseAnime execute(IntegrationsParams params) {
        super.execute(params);
        return this.requestObject();
    }
}