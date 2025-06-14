package com.dio.master.integrations.configs.clients.services.omdb;

import com.dio.master.core.domain.model.Serie;
import com.dio.master.core.gateways.out.GatewayRetrieveSeries;
import com.dio.master.integrations.configs.clients.mappers.omdb.SeriesMapperIntegration;
import com.dio.master.integrations.configs.clients.params.omdb.OmdbParamsSerie;
import com.dio.master.integrations.configs.clients.requests.omdb.OmdbRequestSerie;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponse;
import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponseSerie;
import com.dio.master.integrations.validators.omdb.ValidatorOmdb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OmdbServiceSeries implements GatewayRetrieveSeries {

    private final SeriesMapperIntegration seriesMapperIntegration;
    private final List<ValidatorOmdb<OmdbResponse>> validators;

    @Override
    public Serie doRequest(String imdbID) {
        OmdbParamsSerie params = new OmdbParamsSerie(imdbID);
        OmdbRequestSerie request = new OmdbRequestSerie();
        OmdbResponseSerie response = request.requestObject(params);

        validators.forEach(validator -> validator.validate(response, imdbID));

        return seriesMapperIntegration.toDomain(response);
    }
}
