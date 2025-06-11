package com.dio.master.core.gateways.out;

import com.dio.master.app.validations.CheckImdbID;
import com.dio.master.core.domain.model.Movie;
import org.springframework.validation.annotation.Validated;

@Validated
public interface GatewayRetrieveMovies {

    Movie doRequest(@CheckImdbID final String imdbID);
}