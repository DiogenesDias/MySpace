package com.dio.master.integrations.configs.clients.requests.omdb;

import com.dio.master.integrations.configs.IntegrationsParams;
import com.dio.master.integrations.configs.IntegrationsService;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseSerie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OmdbRequestSerie extends IntegrationsService<OmdbResponseSerie> {

    @Override
    public OmdbResponseSerie execute(IntegrationsParams params) {
        super.execute(params);
        return this.requestObject();
    }
}