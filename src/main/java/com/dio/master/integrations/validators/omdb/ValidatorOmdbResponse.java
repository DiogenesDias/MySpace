package com.dio.master.integrations.validators.omdb;

import com.dio.master.integrations.configs.clients.responses.omdb.OmdbResponse;
import com.dio.master.integrations.exceptions.model.IntgrOmdbResponseException;
import org.springframework.stereotype.Component;

@Component
public class ValidatorOmdbResponse implements ValidatorOmdb<OmdbResponse> {

    @Override
    public void validate(OmdbResponse object, String imdbID) {
        if (!object.apiResponse()) {
            throw new IntgrOmdbResponseException(imdbID);
        }
    }
}
