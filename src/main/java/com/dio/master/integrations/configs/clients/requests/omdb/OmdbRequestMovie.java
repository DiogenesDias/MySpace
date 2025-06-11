package com.dio.master.integrations.configs.clients.requests.omdb;

import com.dio.master.integrations.configs.IntegrationsParams;
import com.dio.master.integrations.configs.IntegrationsService;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseMovie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OmdbRequestMovie extends IntegrationsService<OmdbResponseMovie> {

    @Override
    public OmdbResponseMovie execute(IntegrationsParams params) {
        super.execute(params);
        return this.requestObject();
    }
}