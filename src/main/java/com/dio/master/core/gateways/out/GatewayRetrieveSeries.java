package com.dio.master.core.gateways.out;

import com.dio.master.app.validations.CheckImdbID;
import com.dio.master.core.domain.model.Serie;
import org.springframework.validation.annotation.Validated;

@Validated
public interface GatewayRetrieveSeries {

    Serie doRequest(@CheckImdbID final String imdbID);
}