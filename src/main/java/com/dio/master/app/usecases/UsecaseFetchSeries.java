package com.dio.master.app.usecases;

import com.dio.master.api.dto.responses.SerieResponse;
import com.dio.master.app.mappers.SeriesMapper;
import com.dio.master.core.domain.model.Serie;
import com.dio.master.core.gateways.out.GatewayRetrieveSeries;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsecaseFetchSeries {

    private final GatewayRetrieveSeries usecaseGateway;
    private final SeriesMapper seriesMapper;

    public SerieResponse execute(String imdbID) {
        Serie serie = usecaseGateway.doRequest(imdbID);
        return seriesMapper.toResponse(serie);
    }
}
